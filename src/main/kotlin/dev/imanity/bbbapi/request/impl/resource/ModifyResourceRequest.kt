package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ModifyResourceRequest(
    resourceId: Int,
    title: String,
    tagline: String,
    description: String) : Request<Unit>(
    "resources/$resourceId",
    Method.PATCH,
    mapOf(
        "title" to title,
        "tag_line" to tagline,
        "description" to description
    )
)