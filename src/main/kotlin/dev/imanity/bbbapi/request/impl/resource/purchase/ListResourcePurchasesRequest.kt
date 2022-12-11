package dev.imanity.bbbapi.request.impl.resource.purchase

import dev.imanity.bbbapi.model.Purchase
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ListResourcePurchasesRequest(
    val resourceId: Int,
    val sortOptions: SortOptions
) : Request<Array<Purchase>>(
    "resources/$resourceId/purchases${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<Purchase> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}