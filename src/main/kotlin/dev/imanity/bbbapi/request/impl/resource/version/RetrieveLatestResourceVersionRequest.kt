package dev.imanity.bbbapi.request.impl.resource.version

import dev.imanity.bbbapi.model.Version
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class RetrieveLatestResourceVersionRequest(
    val resourceId: Int
): Request<Version>(
    "resources/$resourceId/versions/latest",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Version {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}