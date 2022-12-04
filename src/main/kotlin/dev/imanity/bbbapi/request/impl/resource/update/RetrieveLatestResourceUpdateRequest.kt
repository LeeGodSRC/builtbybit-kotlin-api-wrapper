package dev.imanity.bbbapi.request.impl.resource.update

import dev.imanity.bbbapi.model.Update
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveLatestResourceUpdateRequest(
    val resourceId: Int
): Request<Update>(
    "resources/$resourceId/updates/latest",
    Method.GET,
    null
)