package dev.imanity.bbbapi.request.impl.alert

import dev.imanity.bbbapi.model.Alert
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListUnreadAlertsRequest(
    sortOptions: SortOptions
): Request<Array<Alert>>(
    "alerts/alerts${sortOptions}",
    Method.GET,
    null
)