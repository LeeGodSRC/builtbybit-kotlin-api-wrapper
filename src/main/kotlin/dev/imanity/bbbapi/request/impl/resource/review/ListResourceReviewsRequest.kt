package dev.imanity.bbbapi.request.impl.resource.review

import dev.imanity.bbbapi.model.Review
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListResourceReviewsRequest(
    resourceId: Int,
    sortOptions: SortOptions
) : Request<Array<Review>>(
    "resources/$resourceId/reviews${sortOptions}",
    Method.GET,
    null
)