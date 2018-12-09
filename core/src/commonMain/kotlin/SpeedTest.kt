package com.sample.core.shared

import kotlin.system.getTimeNanos
import kotlin.math.round

class SpeedTest(val client : HttpClientInterface) {
    private val hundredMegaByteFile = "https://speed.hetzner.de/100MB.bin"
    private val oneMegaByte = 1024*1024
    private var startTime : Long = 0

    // call back
    var testProgressString : ((String)->Unit)? = null
    var testKbpsSpeedUpdate : ((Double)->Unit)? = null
    var testProgressPercentageUpdate : ((Double)->Unit)? = null
    var testElapsedTime : ((Long)->Unit)? = null

    fun simpleTest() {
        client.prepare(hundredMegaByteFile)
        client.progressHandler = ::progressHandler
        startTime = getTimeNanos();
        client.start()
    }

    fun progressHandler(progressPercentage : Double) {
        val lapseTimeInNano = getTimeNanos() - startTime
        val lapseTimeInSeconds = lapseTimeInNano/1000000000
        val sizeDownloadedInBytes = 100 * oneMegaByte * progressPercentage

        val bytesPerSecond = sizeDownloadedInBytes/lapseTimeInSeconds
        val kbpsValue = bytesPerSecond/1024

        val progressValue = round(progressPercentage*1000)/10
        testProgressString?.invoke("Speed: ${kbpsValue} kbps (progress:${progressValue}% duration:${lapseTimeInSeconds}s)")
        testKbpsSpeedUpdate?.invoke(kbpsValue)
        testProgressPercentageUpdate?.invoke(progressPercentage)
        testElapsedTime?.invoke(lapseTimeInSeconds)
    }
}
