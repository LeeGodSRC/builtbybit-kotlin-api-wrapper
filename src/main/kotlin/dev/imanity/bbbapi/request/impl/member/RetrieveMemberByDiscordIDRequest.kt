package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.model.Member
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveMemberByDiscordIDRequest(
    val discordId: Long
): Request<Member>(
    "members/discord/$discordId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Member {
        return decodeResponse(httpResponse)
    }
}