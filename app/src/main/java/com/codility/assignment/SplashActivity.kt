package com.codility.assignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    private var mHandler: Handler? = null

    private val runnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Initialize the Handler
        mHandler = Handler()
        mHandler!!.postDelayed(runnable, 2000)
    }

    public override fun onDestroy() {
        if (mHandler != null) {
            mHandler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }
}