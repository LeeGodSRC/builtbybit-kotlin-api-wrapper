package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class ProfilePost(
    @SerializedName("profile_post_id") val profilePostId: Int,
    @SerializedName("author_id") val authorId: Int,
    @SerializedName("post_date") val postDate: Long,
    @SerializedName("message") val message: String
    )