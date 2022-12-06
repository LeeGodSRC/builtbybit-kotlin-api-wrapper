package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Conversation(
    @SerializedName("conversation_id") val conversationId: Int,
    val title: String,
    @SerializedName("creation_date") val creationDate: Long,
    @SerializedName("creator_id") val creatorId: Int,
    @SerializedName("last_message_id") val lastMessageId: Long,
    @SerializedName("last_read_date") val lastReadDate: Long,
    @SerializedName("is_open") val isOpen: Boolean,
    @SerializedName("reply_count") val replyCount: Int,
    @SerializedName("recipient_ids") val recipientIds: IntArray
)