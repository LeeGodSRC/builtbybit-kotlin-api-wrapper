package dev.imanity.bbbapi.request.impl.resource.review

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RespondToResourceReviewRequest(
    val resourceId: Int,
    val reviewId: Int,
    val response: String
): Request<Unit>(
    "resources/$resourceId/reviews/$reviewId",
    Method.PATCH,
    response
) {
    override suspend fun decode(httpResponse: HttpResponse): Unit {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}