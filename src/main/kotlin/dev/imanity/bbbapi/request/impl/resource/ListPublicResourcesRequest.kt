package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.model.BasicResource
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ListPublicResourcesRequest(val sortOptions: SortOptions) : Request<Array<BasicResource>>(
    "resources${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<BasicResource> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}