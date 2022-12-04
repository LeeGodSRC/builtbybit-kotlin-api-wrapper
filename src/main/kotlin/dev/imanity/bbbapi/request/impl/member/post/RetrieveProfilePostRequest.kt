package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.model.ProfilePost
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveProfilePostRequest(
    val profilePostId: Int
): Request<ProfilePost>(
    "members/self/profile-posts/$profilePostId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<ProfilePost> {
        return decodeResponse(httpResponse)
    }
}