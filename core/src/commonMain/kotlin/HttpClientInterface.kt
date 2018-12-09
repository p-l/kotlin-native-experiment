package com.sample.core.shared

interface HttpClientInterface {

    //var successHandler: ((Data) -> Unit)?
    var errorHandler: ((Error) -> Unit)?
    var progressHandler: ((Double) -> Unit)?

    fun prepare(targetURL: String)
    fun start()
}