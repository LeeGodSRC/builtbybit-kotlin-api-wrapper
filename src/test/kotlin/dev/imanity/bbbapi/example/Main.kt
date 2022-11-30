package dev.imanity.bbbapi.example

import dev.imanity.bbbapi.BBBClient
import dev.imanity.bbbapi.model.Token
import dev.imanity.bbbapi.model.Type
import dev.imanity.bbbapi.request.impl.retrieveResourceById
import kotlinx.coroutines.runBlocking

fun main() {
    val client = BBBClient(
        Token(
            "",
            Type.PRIVATE
        )
    )

    runBlocking {
        val response = client.retrieveResourceById(10770)

        println(response)
    }
}