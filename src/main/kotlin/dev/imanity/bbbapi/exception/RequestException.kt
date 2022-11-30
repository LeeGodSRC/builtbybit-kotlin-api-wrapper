package dev.imanity.bbbapi.exception

open class RequestException : Exception {

    constructor(): super()
    constructor(exception: Exception) : super(exception)
    constructor(message: String): super(message)

}