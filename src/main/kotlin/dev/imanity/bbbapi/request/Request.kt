package dev.imanity.bbbapi.request

open class Request<T>(urlPath: String,
                      val method: Method,
                      val body: Any?) {
    val url = "https://api.builtbybit.com/v1/$urlPath"
}