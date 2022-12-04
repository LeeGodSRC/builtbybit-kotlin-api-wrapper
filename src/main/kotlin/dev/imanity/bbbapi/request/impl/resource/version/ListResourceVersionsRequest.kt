package dev.imanity.bbbapi.request.impl.resource.version

import dev.imanity.bbbapi.model.Version
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class ListResourceVersionsRequest(
    val resourceId: Int,
    val sortOptions: SortOptions
): Request<Array<Version>>(
    "resources/$resourceId/versions${sortOptions}",
    Method.GET,
    null
)