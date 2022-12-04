package dev.imanity.bbbapi.request.impl.thread

import dev.imanity.bbbapi.model.Thread
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class ListThreadsRequest(val sortOptions: SortOptions): Request<Array<Thread>>(
    "threads${sortOptions}",
    Method.GET,
    null
)