package dev.imanity.bbbapi.request.impl.resource.version

import dev.imanity.bbbapi.model.Version
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ListResourceVersionsRequest(
    val resourceId: Int,
    val sortOptions: SortOptions
): Request<Array<Version>>(
    "resources/$resourceId/versions${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<Array<Version>> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}