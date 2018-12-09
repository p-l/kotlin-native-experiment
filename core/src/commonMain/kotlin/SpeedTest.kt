package com.sample.core.shared

class SpeedTest(val client : HttpClientInterface) {
    private val hundredMegaByteFile = "https://speed.hetzner.de/100MB.bin"

    var testProgress : ((String)->Unit)? = null

    fun simpleTest() {
        client.prepare(hundredMegaByteFile)
        client.progressHandler = ::progressHandler
        client.start()
    }

    fun progressHandler(progress : Double) {
        testProgress?.invoke("Progress Handler: ${progress}%")
    }
}
