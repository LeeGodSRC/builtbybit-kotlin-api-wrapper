package dev.imanity.bbbapi.request.impl.resource.review

import dev.imanity.bbbapi.model.Review
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveMemberResourceReviewRequest(
    val resourceId: Int,
    val memberId: Int
) : Request<Review>(
    "resources/$resourceId/reviews/members/$memberId",
    Method.GET,
    null
)