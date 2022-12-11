package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ModifyResourceRequest(
    val resourceId: Int,
    val title: String,
    val tagline: String,
    val description: String
) : Request<Unit>(
    "resources/$resourceId",
    Method.PATCH,
    mapOf(
        "title" to title,
        "tag_line" to tagline,
        "description" to description
    )
) {
    override suspend fun decode(httpResponse: HttpResponse): Unit {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}