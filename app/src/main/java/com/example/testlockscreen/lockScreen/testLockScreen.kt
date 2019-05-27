package com.example.testlockscreen.lockScreen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.testlockscreen.R

class testLockScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flagInit()
        setContentView(R.layout.lock_screen)
        setClock()
    }

    private fun setClock() {

    }

    override fun onResume() {
        super.onResume()
        Log.e("lifeCycle", "resume")
//        ThreadOn
    }

    override fun onPause() {
        super.onPause()
        Log.e("lifeCycle", "pause")
//        ThreadOff
    }

    @SuppressLint("NewApi")
    private fun flagInit() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.run {
            decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_FULLSCREEN)

            setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) setShowWhenLocked(true)
            else addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        }
    }
}