package dev.imanity.bbbapi.example

import dev.imanity.bbbapi.BBBClient
import dev.imanity.bbbapi.model.Token
import dev.imanity.bbbapi.model.Type
import dev.imanity.bbbapi.model.sort.Order
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.listPublicResources
import kotlinx.coroutines.runBlocking

fun main() {
    val client = BBBClient(Token("TOKEN STRING", Type.PRIVATE))

    runBlocking {
        val resourceArray = client.listPublicResources(SortOptions(
            "purchase_count",
            Order.DESCENDING,
            1
        ))

        println(resourceArray)
    }
}