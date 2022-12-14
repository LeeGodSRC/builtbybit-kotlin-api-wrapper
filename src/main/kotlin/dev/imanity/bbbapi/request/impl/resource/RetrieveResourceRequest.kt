package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.model.Resource
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class RetrieveResourceRequest(val resourceId: Int) :
    Request<Resource>("resources/$resourceId", Method.GET, null) {
    override suspend fun decode(httpResponse: HttpResponse): Resource {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}