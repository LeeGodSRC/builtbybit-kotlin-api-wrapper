package dev.imanity.bbbapi.request.impl.resource.review

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RespondToResourceReviewRequest(
    resourceId: Int,
    reviewId: Int,
    response: String
): Request<Unit>(
    "resources/$resourceId/reviews/$reviewId",
    Method.PATCH,
    response
)