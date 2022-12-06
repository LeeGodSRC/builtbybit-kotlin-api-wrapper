package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("review_id") val reviewId: Int,
    @SerializedName("reviewer_id") val reviewerId: Int,
    @SerializedName("review_date") val reviewDate: Long,
    val rating: Int,
    val message: String,
    @SerializedName("response") val authorResponse: String
)