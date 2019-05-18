package com.example.testlockscreen.service

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import com.example.testlockscreen.broadcast.lockBroadcastReceiver

class lockScreenService: Service() {

    private val lockReceiver: BroadcastReceiver by lazy(LazyThreadSafetyMode.NONE) { lockBroadcastReceiver() }

    override fun onCreate() {
        super.onCreate()
        initFilter()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent notNull { initFilter() }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(lockReceiver)
    }

    private fun initFilter() {
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        registerReceiver(lockReceiver, filter)
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private infix fun <T: Any?> T?.notNull(f: T?.() -> Unit) {
        if(this != null) f()
    }
}