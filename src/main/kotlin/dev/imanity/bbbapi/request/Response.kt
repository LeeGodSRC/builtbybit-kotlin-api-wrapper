package dev.imanity.bbbapi.request

data class Response<out T>(
    val type: Type,
    val value: T?,
    val error: Error?,
    val exception: Throwable?,
    val rateLimitTime: Long
) {
    companion object {

        fun <T> success(value: T): Response<T> {
            return Response(Type.SUCCESS, value, null, null, 0)
        }

        fun <T> error(error: Error): Response<T> {
            return Response(Type.ERROR, null, error, null, 0)
        }

        fun <T> exception(exception: Throwable): Response<T> {
            return Response(Type.EXCEPTION, null, null, exception, 0)
        }

        fun <T> rateLimit(rateLimitTime: Long): Response<T> {
            return Response(Type.RATE_LIMITED, null, null, null, rateLimitTime)
        }

    }
}

enum class Type {
    SUCCESS,
    ERROR,
    EXCEPTION,
    RATE_LIMITED
}