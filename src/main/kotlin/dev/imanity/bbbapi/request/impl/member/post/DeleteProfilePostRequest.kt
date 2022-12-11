package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class DeleteProfilePostRequest(
    val profilePostId: Int
) : Request<Unit>(
    "members/profile-posts/$profilePostId",
    Method.DELETE,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse) {
        return decodeResponse(httpResponse)
    }
}