package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class ListResourceLicensesRequest(
    val resourceId: Int,
    val sortOptions: SortOptions) : Request<Array<License>>(
    "resources/$resourceId/licenses${sortOptions}",
    Method.GET,
    null
)