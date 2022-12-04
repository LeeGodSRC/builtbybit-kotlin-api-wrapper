package dev.imanity.bbbapi.request.impl.conversation.reply

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class ReplyToUnreadConversationRequest(
    val conversationId: Int,
    val message: String
): Request<Int>(
    "conversations/$conversationId/replies",
    Method.POST,
    mapOf(
        "message" to message,
    ),
)