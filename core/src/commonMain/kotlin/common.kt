package com.sample.core.shared

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    var message = "Kotlin Rocks on ${platformName()}"
    return message
}

