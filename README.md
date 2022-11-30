[![](https://jitpack.io/v/LeeGodSRC/builtbybit-kotlin-api-wrapper.svg)](https://jitpack.io/#LeeGodSRC/builtbybit-kotlin-api-wrapper)

# builtbybit-kotlin-api-wrapper

---

A Kotlin wrapper for the [BuiltByBit Ultimate API](https://builtbybit.com/wiki/ultimate-api/) built with Kotlin and KotlinX in combination with the [Ktor HTTP Client](https://ktor.io/clients/http-client.html) and [KotlinX Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html).

Most of the data structures are copied from the [BuiltByBit Java API Wrapper](https://github.com/swanis/builtbybit-java-api-wrapper) by [swanis](https://github.com/swanis), You will find a lot of similarities in the code.

## Send a request

---

```kotlin
val client = BBBClient(Token("TOKEN STRING", Type.PRIVATE))

runBlocking {
    val response = client.healthReport()
    println(response)

    val member = client.retrieveYourself()
    println(member)
}
```

Every request action are suspend functions, so you can use them in a coroutine scope.

You can find every request action in the extension functions class [BBBClientRequestExtensions.kt](src/main/kotlin/dev/imanity/bbbapi/request/BBBClientRequestExtensions.kt).

## Exception Handling

---

When a request failed, It will throw a [RequestException](src/main/kotlin/dev/imanity/bbbapi/exception/RequestException.kt).
There are 3 types of exceptions:
- [RequestErrorException](src/main/kotlin/dev/imanity/bbbapi/exception/RequestErrorException.kt) - When the request failed and send from server side. (Maybe a server side error, or a bad request) 
- [RequestThrowsException](src/main/kotlin/dev/imanity/bbbapi/exception/RequestThrowsException.kt) - When the request failed because it throws an exception during processing. (Deserialization error, timeout, etc.)
- [RequestRateLimitedException](src/main/kotlin/dev/imanity/bbbapi/exception/RequestRateLimitedException.kt) - When the request failed because the request is rate limited. (You can get the retry after value from the exception)
  - You wouldn't need to handle this exception when you have wait parameter as true.

## Sorting

---

Sorting is done by passing a SortOptions object into the request action parameters.

```kotlin
val client = BBBClient(Token("TOKEN STRING", Type.PRIVATE))

runBlocking {
    val resourceArray = client.listPublicResources(SortOptions(
        "purchase_count",
        Order.DESCENDING,
        1
    ))

    println(resourceArray)
}
```

### JitPack Installation

---

**Gradle Groovy**

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.LeeGodSRC:builtbybit-kotlin-api-wrapper:Tag'
}
```

**Gradle Kotlin**
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.LeeGodSRC:builtbybit-kotlin-api-wrapper:Tag")
}
```
