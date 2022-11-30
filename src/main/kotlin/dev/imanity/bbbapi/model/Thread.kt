package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thread(
    @SerialName("thread_id") val threadId: Int,
    @SerialName("forum_name") val forumName: String,
    val title: String,
    @SerialName("reply_count") val replyCount: Int,
    @SerialName("view_count") val viewCount: Int,
    @SerialName("post_date") val postDate: Long,
    @SerialName("is_thread_open") val isThreadOpen: Boolean,
    @SerialName("last_post_date") val lastPostDate: Long
)