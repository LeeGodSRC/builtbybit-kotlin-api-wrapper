package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.model.Member
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class RetrieveMemberByIDRequest(
    val id: Int
): Request<Member>(
    "members/$id",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Member {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}