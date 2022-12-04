package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class DeleteProfilePostRequest(
    val profilePostId: Int
): Request<Unit>(
    "members/profile-posts/$profilePostId",
    Method.DELETE,
    null
)