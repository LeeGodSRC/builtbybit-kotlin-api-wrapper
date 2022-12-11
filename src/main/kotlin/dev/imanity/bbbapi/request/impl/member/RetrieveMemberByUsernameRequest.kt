package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.model.Member
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveMemberByUsernameRequest(
    val username: String
): Request<Member>(
    "members/usernames/$username",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Member {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}