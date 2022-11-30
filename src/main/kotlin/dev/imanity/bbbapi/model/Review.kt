package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    @SerialName("review_id") val reviewId: Int,
    @SerialName("resource_id") val resourceId: Int,
    @SerialName("version_id") val versionId: Int,
    @SerialName("version_name") val versionName: String,
    @SerialName("reviewer_id") val reviewerId: Int,
    @SerialName("review_date") val reviewDate: Long,
    @SerialName("is_deleted") val isDeleted: Boolean,
    val rating: Int,
    val message: String,
    @SerialName("author_response") val authorResponse: String
)