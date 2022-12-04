package dev.imanity.bbbapi.request.impl.resource.purchase

import dev.imanity.bbbapi.model.Purchase
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveResourcePurchaseRequest(
    val resourceId: Int,
    val purchaseId: Int
) : Request<Purchase>(
    "resources/$resourceId/purchases/$purchaseId",
    Method.GET,
    null
)