package dev.imanity.bbbapi.request.impl.conversation.reply

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ReplyToUnreadConversationRequest(
    conversationId: Int,
    message: String
): Request<Int>(
    "conversations/$conversationId/replies",
    Method.POST,
    mapOf(
        "message" to message,
    ),
)