package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class EditProfilePostRequest(
    val profilePostId: Int,
    val content: String
): Request<Unit>(
    "members/profile-posts/$profilePostId",
    Method.POST,
    mapOf(
        "message" to content
    )
)