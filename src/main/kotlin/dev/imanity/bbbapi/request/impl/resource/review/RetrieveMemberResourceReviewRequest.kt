package dev.imanity.bbbapi.request.impl.resource.review

import dev.imanity.bbbapi.model.Review
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class RetrieveMemberResourceReviewRequest(
    val resourceId: Int,
    val memberId: Int
) : Request<Review>(
    "resources/$resourceId/reviews/members/$memberId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Review {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}