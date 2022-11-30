package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasicResource(
    @SerialName("resource_id") val resourceId: Int,
    @SerialName("author_id") val authorId: Int,
    val title: String,
    @SerialName("tag_line") val tagLine: String,
    val price: Double,
    val currency: String,
)