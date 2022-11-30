package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Conversation(
    @SerialName("conversation_id") val conversationId: Int,
    val title: String,
    @SerialName("creation_date") val creationDate: Long,
    @SerialName("creator_id") val creatorId: Int,
    @SerialName("last_message_id") val lastMessageId: Long,
    @SerialName("last_read_date") val lastReadDate: Long,
    @SerialName("is_open") val isOpen: Boolean,
    @SerialName("reply_count") val replyCount: Int,
    @SerialName("recipient_ids") val recipientIds: IntArray
)