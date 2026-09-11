package com.example.webdevlabs

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBar = findViewById<ProgressBar>(R.id.splashProgressBar)

        progressBar.postDelayed({
            val nextActivity = if (!UserPreferences.hasCredentials(this)) {
                RegistrationActivity::class.java
            } else if (UserPreferences.isAutoLoginEnabled(this)) {
                ContentActivity::class.java
            } else {
                LoginActivity::class.java
            }

            startActivity(Intent(this, nextActivity))
            finish()
        }, 700)
    }
}
