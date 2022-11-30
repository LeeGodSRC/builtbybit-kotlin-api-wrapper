package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import java.lang.reflect.Member

class RetrieveMemberByIDRequest(
    id: Int
): Request<Member>(
    "members/$id",
    Method.GET,
    null
)