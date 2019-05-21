package com.example.testlockscreen.lockScreen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.testlockscreen.R

class testLockScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flagInit()
        setContentView(R.layout.lock_screen)

    }

    @SuppressLint("NewApi")
    private fun flagInit() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.run {
            setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) setShowWhenLocked(true)
            else addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        }
    }
}