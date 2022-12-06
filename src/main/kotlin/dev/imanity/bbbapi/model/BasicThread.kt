package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class BasicThread(
    @SerializedName("thread_id") val threadId: Int,
    val title: String,
    @SerializedName("reply_count") val replyCount: Int,
    @SerializedName("view_count") val viewCount: Int,
    @SerializedName("creation_date") val creationDate: Long,
    @SerializedName("last_message_date") val lastMessageDate: Long
)