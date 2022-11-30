package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveResourceLicenseRequest(
    resourceId: Int,
    licenseId: Int
) : Request<License>(
    "resources/$resourceId/licenses/$licenseId",
    Method.GET,
    null
)