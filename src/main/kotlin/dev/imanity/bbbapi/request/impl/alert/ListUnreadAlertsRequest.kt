package dev.imanity.bbbapi.request.impl.alert

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.model.Alert
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ListUnreadAlertsRequest(
    val sortOptions: SortOptions
): Request<Array<Alert>>(
    "alerts/alerts${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<Array<Alert>> {
        return decodeResponse(httpResponse)
    }
}