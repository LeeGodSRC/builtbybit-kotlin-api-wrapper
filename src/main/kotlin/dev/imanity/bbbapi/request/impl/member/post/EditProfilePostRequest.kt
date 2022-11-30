package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class EditProfilePostRequest(
    profilePostId: Int,
    content: String
): Request<Unit>(
    "members/profile-posts/$profilePostId",
    Method.POST,
    mapOf(
        "message" to content
    )
)