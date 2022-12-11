package dev.imanity.bbbapi.request.impl.resource.purchase

import dev.imanity.bbbapi.model.Purchase
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class RetrieveResourcePurchaseRequest(
    val resourceId: Int,
    val purchaseId: Int
) : Request<Purchase>(
    "resources/$resourceId/purchases/$purchaseId",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Purchase {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}