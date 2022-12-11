package dev.imanity.bbbapi.request.impl.thread.reply

import dev.imanity.bbbapi.model.Reply
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ReplyToThreadRequest(val threadId: Int, val message: String): Request<Reply> (
    "threads/$threadId/replies",
    Method.POST,
    mapOf("message" to message)
) {
    override suspend fun decode(httpResponse: HttpResponse): Reply {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}