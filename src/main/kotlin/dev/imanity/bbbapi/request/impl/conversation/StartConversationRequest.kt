package dev.imanity.bbbapi.request.impl.conversation

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class StartConversationRequest(
    userIds: Array<Int>,
    title: String,
    message: String
): Request<Int>(
    "conversations",
    Method.POST,
    mapOf(
        "recipient_ids" to userIds,
        "title" to title,
        "message" to message
    )
)