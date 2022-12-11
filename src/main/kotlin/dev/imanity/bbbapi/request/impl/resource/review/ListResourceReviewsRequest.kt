package dev.imanity.bbbapi.request.impl.resource.review

import dev.imanity.bbbapi.model.Review
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ListResourceReviewsRequest(
    val resourceId: Int,
    val sortOptions: SortOptions
) : Request<Array<Review>>(
    "resources/$resourceId/reviews${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<Review> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}