package dev.imanity.bbbapi.request.impl.resource.version

import dev.imanity.bbbapi.model.Version
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveResourceVersionRequest(
    resourceId: Int,
    versionId: Int
): Request<Version>(
    "resources/$resourceId/versions/$versionId",
    Method.GET,
    null
)