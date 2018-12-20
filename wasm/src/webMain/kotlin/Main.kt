package sample.wasm

import shared.core.Welcome
import kotlinx.interop.wasm.dom.*
import kotlinx.wasm.jsinterop.*


fun main() {
    Printer().printMessage()
}

class Printer {
    @Retain
    public fun printMessage() {
        println(Welcome().createApplicationScreenMessage())
    }
}
