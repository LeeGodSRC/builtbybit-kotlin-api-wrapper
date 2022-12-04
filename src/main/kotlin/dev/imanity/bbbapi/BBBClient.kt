package dev.imanity.bbbapi

import dev.imanity.bbbapi.model.Token
import dev.imanity.bbbapi.request.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

class BBBClient(val token: Token) : Closeable {

    private val throttler = Throttler()
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun <T : Any> execute(request: Request<T>, wait: Boolean = true): Response<T> {
        while (wait) {
            val stall = throttler.stall(request.method)
            if (stall <= 0) {
                break
            }

            delay(stall)

            val response = this.executeRequest(request)
            if (response.type == Type.RATE_LIMITED) {
                if (request.method == Method.GET) {
                    throttler.read = response.rateLimitTime
                } else {
                    throttler.write = response.rateLimitTime
                }
                continue
            }

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
        Response(Type.EXCEPTION, null, null, it, 0)
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

suspend inline fun <reified T : Any> decodeResponse(response: HttpResponse): Response<T> {
    val body = response.body<ResponseBody<T>>()
    return if (response.headers.contains("Retry-After")) {
        Response(response.headers["Retry-After"]!!.toLong())
    } else if (body.result == "error") {
        Response(body.error!!)
    } else {
        Response(body.data!!)
    }
}