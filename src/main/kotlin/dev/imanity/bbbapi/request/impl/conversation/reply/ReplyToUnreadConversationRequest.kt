package dev.imanity.bbbapi.request.impl.conversation.reply

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ReplyToUnreadConversationRequest(
    val conversationId: Int,
    val message: String
): Request<Int>(
    "conversations/$conversationId/replies",
    Method.POST,
    mapOf(
        "message" to message,
    ),
) {
    override suspend fun decode(httpResponse: HttpResponse): Int {
        return decodeResponse(httpResponse)
    }
}