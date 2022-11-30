package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import java.lang.reflect.Member

class RetrieveYourselfRequest: Request<Member>(
    "members/self",
    Method.GET,
    null
)