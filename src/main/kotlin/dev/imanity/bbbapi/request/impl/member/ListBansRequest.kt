package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.model.Ban
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import io.ktor.client.statement.*

class ListBansRequest: Request<Array<Ban>>(
    "members/bans",
    Method.GET,
    null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override suspend fun decode(httpResponse: HttpResponse): Array<Ban> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}