package dev.imanity.bbbapi.request.impl.thread.reply

import dev.imanity.bbbapi.model.Reply
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ListThreadRepliesRequest(val threadId: Int, val sortOptions: SortOptions) : Request<Array<Reply>>(
    "threads/$threadId/replies${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<Reply> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}