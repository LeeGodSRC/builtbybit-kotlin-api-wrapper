package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Update(
    @SerialName("update_id") val updateId: Int,
    val title: String,
    val message: String,
    @SerialName("update_date") val updateDate: Long,
    @SerialName("like_count") val likeCount: Int
    )