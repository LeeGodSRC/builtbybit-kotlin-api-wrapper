package dev.imanity.bbbapi.exception

open class RequestException : Exception {

    constructor(): super()
    constructor(exception: Throwable) : super(exception)
    constructor(message: String): super(message)

}