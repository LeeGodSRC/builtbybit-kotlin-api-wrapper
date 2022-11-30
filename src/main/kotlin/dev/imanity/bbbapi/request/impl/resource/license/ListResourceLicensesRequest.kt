package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListResourceLicensesRequest(resourceId: Int, sortOptions: SortOptions) : Request<Array<License>>(
    "resources/$resourceId/licenses${sortOptions}",
    Method.GET,
    null
)