package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.model.Member
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveMemberByIDRequest(
    val id: Int
): Request<Member>(
    "members/$id",
    Method.GET,
    null
)