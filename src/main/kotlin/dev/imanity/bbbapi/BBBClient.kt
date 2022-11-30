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

class BBBClient(val token: Token): Closeable {

    val throttler = Throttler()
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
            //ignoreUnknownKeys = true
        }
    }

    suspend inline fun <reified T : Any> execute(request: Request<T>, wait: Boolean = true): Response<T> {
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

    suspend inline fun <reified T : Any> executeRequest(request: Request<T>): Response<T> {
        return when (request.method) {
            Method.GET -> get(request)
            Method.POST -> post(request, request.body!!)
            Method.DELETE -> delete(request)
            Method.PATCH -> patch(request, request.body!!)
        }
    }

    suspend inline fun <reified T> get(request: Request<T>): Response<T> {
        return try {
            val response = httpClient.get(request.url) {
                headers {
                    append("Authorization", token.urlString)
                }
            }

            decode(response)
        } catch (ex: Exception) {
            Response(ex)
        }
    }

    suspend inline fun <reified T> post(request: Request<T>, body: Any): Response<T> {
        return try {
            val response = httpClient.post(request.url) {
                headers {
                    append("Authorization", token.urlString)
                    append("Content-Type", "application/json")
                }
                setBody(body)
            }

            decode(response)
        } catch (ex: Exception) {
            Response(ex)
        }
    }

    suspend inline fun <reified T> delete(request: Request<T>): Response<T> {
        return try {
            val response = httpClient.delete(request.url) {
                headers {
                    append("Authorization", token.urlString)
                }
            }

            decode(response)
        } catch (ex: Exception) {
            Response(ex)
        }
    }

    suspend inline fun <reified T> patch(request: Request<T>, body: Any): Response<T> {
        return try {
            val response = httpClient.patch(request.url) {
                headers {
                    append("Authorization", token.urlString)
                    append("Content-Type", "application/json")
                }
                setBody(body)
            }

            decode(response)
        } catch (ex: Exception) {
            Response(ex)
        }
    }

    suspend inline fun <reified T> decode(response: HttpResponse): Response<T> {
        val body = response.body<ResponseBody<T>>()
        return if (response.headers.contains("Retry-After")) {
            Response(response.headers["Retry-After"]!!.toLong())
        } else if (body.result == "error") {
            Response(body.error!!)
        } else {
            Response(body.data!!)
        }
    }

    override fun close() {
        httpClient.close()
    }

}