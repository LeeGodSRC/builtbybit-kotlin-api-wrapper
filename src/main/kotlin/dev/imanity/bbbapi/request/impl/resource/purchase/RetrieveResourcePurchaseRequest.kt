package dev.imanity.bbbapi.request.impl.resource.purchase

import dev.imanity.bbbapi.model.Purchase
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveResourcePurchaseRequest(
    resourceId: Int,
    purchaseId: Int
) : Request<Purchase>(
    "resources/$resourceId/purchases/$purchaseId",
    Method.GET,
    null
)