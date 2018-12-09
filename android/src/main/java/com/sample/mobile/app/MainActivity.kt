package com.sample.mobile.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.sample.core.shared.Welcome
import com.sample.core.shared.SpeedTest
import com.sample.mobile.app.http.HttpClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = Welcome().createApplicationScreenMessage()

        // Downloader
        val httpClient = HttpClient()
        val speedTest = SpeedTest(httpClient)
        speedTest.testProgress = {
            println(it)
        }
        speedTest.simpleTest()
    }
}
