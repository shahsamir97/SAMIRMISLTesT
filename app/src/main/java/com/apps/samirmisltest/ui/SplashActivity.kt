package com.apps.samirmisltest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.apps.samirmisltest.R
import com.apps.samirmisltest.utils.HearBeatAnimation

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val appIconImage = findViewById<ImageView>(R.id.imageView)

        HearBeatAnimation.animateHeartBeat(appIconImage)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 5000)

    }
}