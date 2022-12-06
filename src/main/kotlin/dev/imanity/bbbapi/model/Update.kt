package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Update(
    @SerializedName("update_id") val updateId: Int,
    val title: String,
    val message: String,
    @SerializedName("update_date") val updateDate: Long,
    @SerializedName("like_count") val likeCount: Int
    )