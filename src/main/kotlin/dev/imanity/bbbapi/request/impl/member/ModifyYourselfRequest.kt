package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ModifyYourselfRequest(
    val customTitle: String,
    val aboutMe: String,
    val signature: String
): Request<Unit>(
    "members/self",
    Method.PATCH,
    mapOf(
        "custom_title" to customTitle,
        "about_me" to aboutMe,
        "signature" to signature
    )
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<Unit> {
        return decodeResponse(httpResponse)
    }
}