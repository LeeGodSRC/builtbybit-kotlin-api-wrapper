package dev.imanity.bbbapi.request.impl.resource.license

import dev.imanity.bbbapi.model.License
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ListResourceLicensesRequest(
    val resourceId: Int,
    val sortOptions: SortOptions
) : Request<Array<License>>(
    "resources/$resourceId/licenses${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<License> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}