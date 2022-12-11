package dev.imanity.bbbapi

import dev.imanity.bbbapi.exception.RequestErrorException
import dev.imanity.bbbapi.exception.RequestRateLimitedException
import dev.imanity.bbbapi.exception.RequestThrowsException
import dev.imanity.bbbapi.model.Token
import dev.imanity.bbbapi.request.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.gson.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.delay

class BBBClient(private val token: Token) : Closeable {

    private val throttler = Throttler()
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            gson {

            }
        }
    }

    suspend fun <T : Any> execute(request: Request<T>, wait: Boolean = true): T {
        while (wait) {
            val stall = throttler.stall(request.method)
            if (stall <= 0) {
                break
            }

            delay(stall)

            val response = kotlin.runCatching {
                this.executeRequest(request)
            }.getOrElse {
                if (it is RequestRateLimitedException) {
                    if (request.method == Method.GET) {
                        throttler.read = it.retryAfter
                    } else {
                        throttler.write = it.retryAfter
                    }
                    null
                } else {
                    throw it
                }
            } ?: continue

            return response
        }

        return this.executeRequest(request)
    }

    private suspend fun <T : Any> executeRequest(request: Request<T>) = kotlin.runCatching {
        val httpResponse = when (request.method) {
            Method.GET -> get(request)
            Method.POST -> post(request, request.body!!)
            Method.DELETE -> delete(request)
            Method.PATCH -> patch(request, request.body!!)
        }

        request.decode(httpResponse)
    }.getOrElse {
        throw RequestThrowsException(it)
    }

    private suspend fun get(request: Request<*>) = httpClient.get(request.url) {
        headers {
            append("Authorization", token.urlString)
        }
    }

    private suspend fun post(request: Request<*>, body: Any) = httpClient.post(request.url) {
        headers {
            append("Authorization", token.urlString)
            append("Content-Type", "application/json")
        }
        setBody(body)
    }

    private suspend fun delete(request: Request<*>) = httpClient.delete(request.url) {
        headers {
            append("Authorization", token.urlString)
        }
    }

    private suspend fun patch(request: Request<*>, body: Any) = httpClient.patch(request.url) {
        headers {
            append("Authorization", token.urlString)
            append("Content-Type", "application/json")
        }
        setBody(body)
    }

    override fun close() {
        httpClient.close()
    }

}

suspend inline fun <reified T : Any> decodeResponse(response: HttpResponse): T {
    val body = response.body<ResponseBody<T>>()
    return if (response.headers.contains("Retry-After")) {
        throw RequestRateLimitedException(response.headers["Retry-After"]!!.toLong())
    } else if (body.result == "error") {
        throw RequestErrorException(body.error!!)
    } else {
        body.data!!
    }
}