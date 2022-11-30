package dev.imanity.bbbapi.exception

import dev.imanity.bbbapi.request.Error

class RequestErrorException(val error: Error): RequestException()