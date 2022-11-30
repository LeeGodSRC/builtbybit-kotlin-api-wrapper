package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reply(
    @SerialName("reply_id") val replyId: Int,
    @SerialName("author_id") val authorId: Int,
    @SerialName("post_date") val postDate: Long,
    @SerialName("message") val message: String
    )