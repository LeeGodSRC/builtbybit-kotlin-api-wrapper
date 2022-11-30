package dev.imanity.bbbapi.request.impl.thread.reply

import dev.imanity.bbbapi.model.Reply
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ReplyToThreadRequest(threadId: Int, message: String): Request<Reply> (
    "threads/$threadId/replies",
    Method.POST,
    mapOf("message" to message)
)