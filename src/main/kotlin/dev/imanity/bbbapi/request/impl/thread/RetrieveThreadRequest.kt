package dev.imanity.bbbapi.request.impl.thread

import dev.imanity.bbbapi.model.Thread
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveThreadRequest(val threadId: Int): Request<Array<Thread>>(
    "threads/$threadId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<Thread> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}