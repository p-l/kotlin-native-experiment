package com.sample.mobile.app.http

import com.sample.core.shared.HttpClientInterface

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

import okio.Okio

import java.io.File
import java.io.IOException

import kotlin.Error

class HttpClient : HttpClientInterface {
    private var client: OkHttpClient? = null
    private var request: Request? = null
    override var errorHandler: ((Error) -> Unit)? = null
    override var progressHandler: ((Double) -> Unit)? = null


    override fun prepare(targetURL: String) {
        client = OkHttpClient()
        request = Request.Builder()
                .url(targetURL)
                .build()
    }


    override fun start() {
        request?.let {
            client?.run {
                newCall(it).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        errorHandler?.let {
                            val error = Error(e.localizedMessage)
                            println(e)
                            it(error)
                        }
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.body()?.let {
                            val contentLength = it.contentLength()
                            val source = it.source()
                            val destFile = File.createTempFile("file", "bin")

                            val sink = Okio.buffer(Okio.sink(destFile))
                            val sinkBuffer = sink.buffer()

                            var totalBytesRead: Long = 0
                            val bufferSize: Long = 8 * 1024
                            var bytesRead: Long = 0
                            while (bytesRead >= 0) {
                                bytesRead = source.read(sinkBuffer, bufferSize)
                                sink.emit()
                                totalBytesRead += bytesRead
                                val progress = (totalBytesRead * 100 / contentLength).toDouble()
                                progressHandler?.invoke(progress)
                            }
                            sink.flush()
                            sink.close()
                            source.close()
                        }
                    }
                })
            }
        }
    }
}

