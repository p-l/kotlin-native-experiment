package com.sample.core.shared

// iOS has access to kotlin.system.getTimeNanos
// Android doesn't. To avoid implementation nightmare. Abastract it away here.
import kotlin.system.getTimeNanos

actual fun getTimeNanos(): Long {
    return kotlin.system.getTimeNanos();
}

actual fun getTimeMilis(): Long {
    return kotlin.system.getTimeMillis()
}