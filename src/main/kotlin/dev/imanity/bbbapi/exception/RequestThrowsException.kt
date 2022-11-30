package dev.imanity.bbbapi.exception

import java.lang.Exception

class RequestThrowsException(exception: Exception): RuntimeException(exception)