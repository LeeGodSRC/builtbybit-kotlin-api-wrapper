package dev.imanity.bbbapi.request.impl.resource.update

import dev.imanity.bbbapi.model.Update
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveResourceUpdateRequest(
    resourceId: Int,
    updateId: Int
) : Request<Update>(
    "resources/$resourceId/updates/$updateId",
    Method.GET,
    null
)