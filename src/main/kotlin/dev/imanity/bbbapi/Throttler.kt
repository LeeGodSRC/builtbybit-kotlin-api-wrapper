package dev.imanity.bbbapi

import dev.imanity.bbbapi.request.Method
import io.ktor.util.date.*
import java.util.concurrent.atomic.AtomicLong

class Throttler {
    private val readLastRetry = AtomicLong(0)
    private val readLastRequest = AtomicLong(getTimeMillis())
    private val writeLastRetry = AtomicLong(0)
    private val writeLastRequest = AtomicLong(getTimeMillis())

    var read: Long
        get() = readLastRetry.get()
        set(value) {
            readLastRetry.set(value)
            readLastRequest.set(getTimeMillis())
        }

    var write: Long
        get() = writeLastRetry.get()
        set(value) {
            writeLastRetry.set(value)
            writeLastRequest.set(getTimeMillis())
        }

    fun stall(method: Method): Long {
        val time = System.currentTimeMillis()
        return if (method === Method.GET) {
            stallForHelper(readLastRetry, readLastRequest, time)
        } else {
            stallForHelper(writeLastRetry, writeLastRequest, time)
        }
    }

    private fun stallForHelper(aLastRetry: AtomicLong, aLastRequest: AtomicLong, time: Long): Long {
        val lastRetry = aLastRetry.getAcquire()
        val lastRequest = aLastRequest.getAcquire()
        return if (lastRetry > 0 && time - lastRequest < lastRetry) {
            lastRetry - (time - lastRequest)
        } else {
            0
        }
    }
}