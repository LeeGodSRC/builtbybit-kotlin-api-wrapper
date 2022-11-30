package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfilePost(
    @SerialName("profile_post_id") val profilePostId: Int,
    @SerialName("author_id") val authorId: Int,
    @SerialName("post_date") val postDate: Long,
    @SerialName("message") val message: String
    )