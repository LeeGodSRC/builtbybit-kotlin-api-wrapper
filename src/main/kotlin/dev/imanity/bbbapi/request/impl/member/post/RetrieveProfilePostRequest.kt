package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.model.ProfilePost
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveProfilePostRequest(
    val profilePostId: Int
): Request<ProfilePost>(
    "members/self/profile-posts/$profilePostId",
    Method.GET,
    null
)