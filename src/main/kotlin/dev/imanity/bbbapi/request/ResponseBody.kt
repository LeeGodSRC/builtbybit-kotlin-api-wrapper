package dev.imanity.bbbapi.request

import kotlinx.serialization.Serializable

@Serializable
data class ResponseBody<out T>(
    val result: String,
    val data: T? = null,
    val error: Error? = null
)
