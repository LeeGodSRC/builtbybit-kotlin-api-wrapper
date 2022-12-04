package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveResourceLicenseByMemberRequest(
    val resourceId: Int,
    val memberId: Int,
    val nonce: Int,
    val timestamp: Long
) : Request<License>(
    "resources/$resourceId/licenses/members/$memberId",
    Method.GET,
    mapOf(
        "nonce" to nonce,
        "timestamp" to timestamp
    )
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<License> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}