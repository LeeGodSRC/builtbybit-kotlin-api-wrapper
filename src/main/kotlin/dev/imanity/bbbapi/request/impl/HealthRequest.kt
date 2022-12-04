package dev.imanity.bbbapi.request.impl

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class HealthRequest: Request<String>("health", Method.GET, null) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}