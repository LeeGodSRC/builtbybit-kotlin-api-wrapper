package dev.imanity.bbbapi.request.impl.alert

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class MarkUnreadAlertsAsReadRequest(
    val read: Boolean
): Request<Unit>(
    "alerts/alerts",
    Method.PATCH,
    mapOf(
        "read" to read
    )
) {
    override suspend fun decode(httpResponse: HttpResponse) {
        return decodeResponse(httpResponse)
    }
}