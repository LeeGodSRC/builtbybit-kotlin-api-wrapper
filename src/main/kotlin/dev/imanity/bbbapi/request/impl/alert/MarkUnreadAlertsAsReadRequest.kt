package dev.imanity.bbbapi.request.impl.alert

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class MarkUnreadAlertsAsReadRequest(
    val read: Boolean
): Request<Unit>(
    "alerts/alerts",
    Method.PATCH,
    mapOf(
        "read" to read
    )
)