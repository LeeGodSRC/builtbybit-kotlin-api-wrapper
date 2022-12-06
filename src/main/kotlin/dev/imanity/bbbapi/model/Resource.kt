package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Resource(
    @SerializedName("resource_id") val resourceId: Int,
    @SerializedName("author_id") val authorId: Int,
    val title: String,
    @SerializedName("tag_line") val tagLine: String,
    val description: String,
    @SerializedName("release_date") val releaseDate: Long,
    @SerializedName("last_update_date") val lastUpdateDate: Long,
    @SerializedName("is_moderated") val isModerated: Boolean = false,
    @SerializedName("category_title") val categoryTitle: String,
    @SerializedName("current_version_id") val currentVersionId: Int,
    @SerializedName("discussion_thread_id") val discussionThreadId: Int? = null,
    @SerializedName("purchase_count") val purchaseCount: Int,
    val price: Double,
    val currency: String,
    @SerializedName("download_count") val downloadCount: Int,
    @SerializedName("review_count") val reviewCount: Int,
    @SerializedName("review_average") val reviewAverage: Double
)