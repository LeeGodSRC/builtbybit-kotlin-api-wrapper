package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasicThread(
    @SerialName("thread_id") val threadId: Int,
    val title: String,
    @SerialName("reply_count") val replyCount: Int,
    @SerialName("view_count") val viewCount: Int,
    @SerialName("creation_date") val creationDate: Long,
    @SerialName("last_message_date") val lastMessageDate: Long
)