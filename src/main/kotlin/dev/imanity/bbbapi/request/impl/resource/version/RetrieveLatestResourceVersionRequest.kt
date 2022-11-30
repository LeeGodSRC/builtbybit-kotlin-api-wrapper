package dev.imanity.bbbapi.request.impl.resource.version

import dev.imanity.bbbapi.model.Version
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveLatestResourceVersionRequest(
    resourceId: Int
): Request<Version>(
    "resources/$resourceId/versions/latest",
    Method.GET,
    null
)