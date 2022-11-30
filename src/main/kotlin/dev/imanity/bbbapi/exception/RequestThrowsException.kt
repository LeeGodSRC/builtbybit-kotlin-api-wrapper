package dev.imanity.bbbapi.exception

import java.lang.Exception

class RequestThrowsException(val exception: Exception): RequestException(exception)