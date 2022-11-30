package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Resource(
    @SerialName("resource_id") val resourceId: Int,
    @SerialName("author_id") val authorId: Int,
    val title: String,
    @SerialName("tag_line") val tagLine: String,
    val description: String,
    @SerialName("release_date") val releaseDate: Long,
    @SerialName("last_update_date") val lastUpdateDate: Long,
    @SerialName("is_moderated") val isModerated: Boolean = false,
    @SerialName("category_title") val categoryTitle: String,
    @SerialName("current_version_id") val currentVersionId: Int,
    @SerialName("discussion_thread_id") val discussionThreadId: Int? = null,
    @SerialName("purchase_count") val purchaseCount: Int,
    val price: Double,
    val currency: String,
    @SerialName("download_count") val downloadCount: Int,
    @SerialName("review_count") val reviewCount: Int,
    @SerialName("review_average") val reviewAverage: Double
)