package dev.imanity.bbbapi.request.impl.resource.update

import dev.imanity.bbbapi.model.Update
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveLatestResourceUpdateRequest(
    val resourceId: Int
): Request<Update>(
    "resources/$resourceId/updates/latest",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Update {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}