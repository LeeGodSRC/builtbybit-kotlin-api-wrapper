package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class BasicResource(
    @SerializedName("resource_id") val resourceId: Int,
    @SerializedName("author_id") val authorId: Int,
    val title: String,
    @SerializedName("tag_line") val tagLine: String,
    val price: Double,
    val currency: String,
)