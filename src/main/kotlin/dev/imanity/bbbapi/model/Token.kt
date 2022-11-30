package dev.imanity.bbbapi.model

data class Token(
    val tokenString: String,
    val type: Type
) {
    val urlString = "${type.urlName} $tokenString"
}

enum class Type(val urlName: String) {
    PRIVATE("Private"),
    SHARED("Shared")
}
