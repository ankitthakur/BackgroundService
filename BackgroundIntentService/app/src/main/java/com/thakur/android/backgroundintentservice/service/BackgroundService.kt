package com.thakur.android.backgroundintentservice.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class BackgroundService:IntentService("BackgroundService") {

    private val TAG = BackgroundService::class.java.simpleName



    override fun onHandleIntent(intent: Intent?) {
        Log.i(TAG, "Called on handle intent. Thread name ${Thread.currentThread().name}")

        val sleepTime:Int = intent!!.getIntExtra("sleepTime", -1)

        var counter = 1

        while (counter <= sleepTime){
            try {
                Thread.sleep(1000)
                Log.i(TAG, "Processing thread. Thread name ${Thread.currentThread().name} with count : $counter")
            }
            catch (e:InterruptedException){
                e.printStackTrace()
            }
            counter++
        }


    }

    override fun onCreate() {
        super.onCreate()

        Log.i(TAG, "Called on create. Thread name ${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Called on destroy. Thread name ${Thread.currentThread().name}")
    }
}