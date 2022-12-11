package dev.imanity.bbbapi.request.impl

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

class HealthRequest: Request<String>("health", Method.GET, null) {
    override suspend fun decode(httpResponse: HttpResponse): String {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}