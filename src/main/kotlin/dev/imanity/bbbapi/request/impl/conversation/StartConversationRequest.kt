package dev.imanity.bbbapi.request.impl.conversation

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class StartConversationRequest(
    val userIds: Array<Int>,
    val title: String,
    val message: String
): Request<Int>(
    "conversations",
    Method.POST,
    mapOf(
        "recipient_ids" to userIds,
        "title" to title,
        "message" to message
    )
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StartConversationRequest

        if (!userIds.contentEquals(other.userIds)) return false
        if (title != other.title) return false
        if (message != other.message) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userIds.contentHashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + message.hashCode()
        return result
    }
}