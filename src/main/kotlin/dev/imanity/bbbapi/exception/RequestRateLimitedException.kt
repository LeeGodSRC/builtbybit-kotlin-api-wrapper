package dev.imanity.bbbapi.exception

class RequestRateLimitedException(val retryAfter: Long): RequestException()