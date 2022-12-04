package dev.imanity.bbbapi.request.impl.member

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

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
)