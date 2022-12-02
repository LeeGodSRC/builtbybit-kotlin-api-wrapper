package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.model.Member
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveYourselfRequest: Request<Member>(
    "members/self",
    Method.GET,
    null
)