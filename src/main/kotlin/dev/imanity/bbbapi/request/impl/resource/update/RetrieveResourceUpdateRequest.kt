package dev.imanity.bbbapi.request.impl.resource.update

import dev.imanity.bbbapi.model.Update
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveResourceUpdateRequest(
    val resourceId: Int,
    val updateId: Int
) : Request<Update>(
    "resources/$resourceId/updates/$updateId",
    Method.GET,
    null
)