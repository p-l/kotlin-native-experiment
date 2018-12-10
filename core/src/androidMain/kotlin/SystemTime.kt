package shared.core

import java.util.Calendar

actual fun getTimeNanos(): Long {
    println("Get getTimeNanos() called. Lower API implement does not allow for exact time in nano. returning getTimeMilis() * 1000000")
    return getTimeMilis()*1000000
}

actual fun getTimeMilis(): Long {
    return Calendar.getInstance().timeInMillis
}
