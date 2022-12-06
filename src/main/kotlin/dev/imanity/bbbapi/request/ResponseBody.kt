package dev.imanity.bbbapi.request

data class ResponseBody<out T>(
    val result: String,
    val data: T? = null,
    val error: Error? = null
)
