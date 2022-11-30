package dev.imanity.bbbapi.request.impl.thread

import dev.imanity.bbbapi.model.Thread
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveThreadRequest(threadId: Int): Request<Array<Thread>>(
    "threads/$threadId",
    Method.GET,
    null
)