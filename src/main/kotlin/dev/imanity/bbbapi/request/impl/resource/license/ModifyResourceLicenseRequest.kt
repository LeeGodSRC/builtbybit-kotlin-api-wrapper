package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class ModifyResourceLicenseRequest(
    val resourceId: Int,
    val licenseId: Int,
    val permanent: Boolean,
    val active: Boolean,
    val startDate: Long,
    val endDate: Long
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