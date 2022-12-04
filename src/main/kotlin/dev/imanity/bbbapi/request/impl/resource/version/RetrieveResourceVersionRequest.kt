package dev.imanity.bbbapi.request.impl.resource.version

import dev.imanity.bbbapi.model.Version
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveResourceVersionRequest(
    val resourceId: Int,
    val versionId: Int
): Request<Version>(
    "resources/$resourceId/versions/$versionId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<Version> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}