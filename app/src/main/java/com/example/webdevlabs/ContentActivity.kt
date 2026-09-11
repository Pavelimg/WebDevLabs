package com.example.webdevlabs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val logoutButton = findViewById<Button>(R.id.logoutButton)
        val resetSettingsButton = findViewById<Button>(R.id.resetSettingsButton)

        logoutButton.setOnClickListener {
            UserPreferences.saveAutoLogin(this, false)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        resetSettingsButton.setOnClickListener {
            UserPreferences.clear(this)
            startActivity(Intent(this, RegistrationActivity::class.java))
            finish()
        }
    }
}
