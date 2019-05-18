package com.example.testlockscreen.broadcast

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.testlockscreen.lockScreen.testLockScreen

class lockBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_SCREEN_ON -> {
                Log.i("BroadcastReceiver", "ON")
                val i = Intent(context, testLockScreen::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }

                val pendingIntent = PendingIntent.getActivity(context,0, i, 0)
                try {
                    pendingIntent.send()
                } catch (pe: PendingIntent.CanceledException) {
                    pe.printStackTrace()
                }
            }
            Intent.ACTION_SCREEN_OFF -> {
                Log.i("BroadcastReceiver", "OFF")
            }
            Intent.ACTION_BOOT_COMPLETED -> {
                Log.i("BroadcastReceiver", "BOOT")
            }
        }
    }
}