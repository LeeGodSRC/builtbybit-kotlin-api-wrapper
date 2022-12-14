package dev.imanity.bbbapi.request.impl.resource.update

import dev.imanity.bbbapi.model.Update
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ListResourceUpdatesRequest(
    val resourceId: Int,
    val sortOptions: SortOptions
): Request<Array<Update>>(
    "resources/$resourceId/updates${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<Update> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}