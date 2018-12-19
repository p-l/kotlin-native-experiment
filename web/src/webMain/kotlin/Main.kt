package com.sample.mobile.web

import shared.core.Welcome
import kotlinx.interop.wasm.dom.*
import kotlinx.wasm.jsinterop.*


fun main() {
    printMessage()
}

public fun printMessage() {
    println(Welcome().createApplicationScreenMessage())
}
