package sample.web
import shared.core.Welcome

fun main() {
    Printer().printMessage("main says")
}

class Printer {
    public fun printMessage(prefix: String) {
        println(prefix + " - " + Welcome().createApplicationScreenMessage())
    }
}
