package dev.imanity.bbbapi.request.impl.alert

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class MarkUnreadAlertsAsReadRequest(
    read: Boolean
): Request<Unit>(
    "alerts/alerts",
    Method.PATCH,
    mapOf(
        "read" to read
    )
)