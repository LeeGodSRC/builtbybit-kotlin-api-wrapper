package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ModifyResourceLicenseRequest(
    resourceId: Int,
    licenseId: Int,
    permanent: Boolean,
    active: Boolean,
    startDate: Long,
    endDate: Long
) : Request<Unit>(
    "resources/$resourceId/licenses/$licenseId",
    Method.PATCH,
    mapOf(
        "permanent" to permanent,
        "active" to active,
        "start_date" to startDate,
        "end_date" to endDate
    )
)