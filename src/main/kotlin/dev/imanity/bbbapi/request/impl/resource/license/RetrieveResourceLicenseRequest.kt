package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveResourceLicenseRequest(
    val resourceId: Int,
    val licenseId: Int
) : Request<License>(
    "resources/$resourceId/licenses/$licenseId",
    Method.GET,
    null
)