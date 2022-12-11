package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveResourceLicenseRequest(
    val resourceId: Int,
    val licenseId: Int
) : Request<License>(
    "resources/$resourceId/licenses/$licenseId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): License {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}