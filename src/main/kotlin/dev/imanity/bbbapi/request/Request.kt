package dev.imanity.bbbapi.request

import io.ktor.client.statement.*

abstract class Request<T>(urlPath: String,
                      val method: Method,
                      val body: Any?) {
    val url = "https://api.builtbybit.com/v1/$urlPath"

    abstract suspend fun decode(httpResponse: HttpResponse): Response<T>

}