package dev.imanity.bbbapi.request.impl.resource.download

import dev.imanity.bbbapi.model.Download
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class ListResourceDownloadsRequest(
    val resourceId: Int,
    val sortOptions: SortOptions) : Request<Array<Download>>(
    "resources/$resourceId/downloads${sortOptions}",
    Method.GET,
    null
)