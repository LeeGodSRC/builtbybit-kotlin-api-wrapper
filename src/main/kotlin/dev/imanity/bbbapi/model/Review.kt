package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    @SerialName("review_id") val reviewId: Int,
    @SerialName("reviewer_id") val reviewerId: Int,
    @SerialName("review_date") val reviewDate: Long,
    val rating: Int,
    val message: String,
    @SerialName("response") val authorResponse: String
)