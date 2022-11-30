package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.model.BasicResource
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListResourcesByAuthorRequest(userId: Int, sortOptions: SortOptions) : Request<Array<BasicResource>>(
    "resources/author/$userId${sortOptions}",
    Method.GET,
    null
)