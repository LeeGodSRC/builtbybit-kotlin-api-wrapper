package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.model.Ban
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListBansRequest: Request<Array<Ban>>(
    "members/bans",
    Method.GET,
    null
)