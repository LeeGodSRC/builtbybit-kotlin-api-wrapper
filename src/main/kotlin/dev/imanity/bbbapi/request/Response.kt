package dev.imanity.bbbapi.request

import java.lang.Exception

data class Response<out T>(
    val type: Type,
    val value: T?,
    val error: Error?,
    val exception: Throwable?,
    val rateLimitTime: Long
) {
    constructor(error: Error) : this(Type.ERROR, null, error, null, 0)
    constructor(exception: Throwable) : this(Type.EXCEPTION, null, null, exception, 0)
    constructor(rateLimitTime: Long) : this(Type.RATE_LIMITED, null, null, null, rateLimitTime)
    constructor(value: T) : this(Type.SUCCESS, value, null, null, 0)
}

enum class Type {
    SUCCESS,
    ERROR,
    EXCEPTION,
    RATE_LIMITED
}