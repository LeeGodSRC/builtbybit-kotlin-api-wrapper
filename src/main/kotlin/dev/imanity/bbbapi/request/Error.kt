package dev.imanity.bbbapi.request

import kotlinx.serialization.Serializable

@Serializable
data class Error(
    val code: String,
    val message: String
)
