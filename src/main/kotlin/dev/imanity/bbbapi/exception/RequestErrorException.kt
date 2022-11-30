package dev.imanity.bbbapi.exception

import dev.imanity.bbbapi.request.Error

class RequestErrorException(val error: Error): RequestException("An error occurred while making a request to the BBB API: ${error.code} - ${error.message}")