package com.example.webdevlabs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val contactEditText = findViewById<EditText>(R.id.loginContactEditText)
        val passwordEditText = findViewById<EditText>(R.id.loginPasswordEditText)
        val autoLoginCheckBox = findViewById<CheckBox>(R.id.rememberMeCheckBox)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val openRegistrationTextView = findViewById<TextView>(R.id.openRegistrationTextView)

        openRegistrationTextView.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
            finish()
        }

        loginButton.setOnClickListener {
            val contact = contactEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (UserPreferences.credentialsMatch(this, contact, password)) {
                UserPreferences.saveAutoLogin(this, autoLoginCheckBox.isChecked)
                startActivity(Intent(this, ContentActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, R.string.invalid_credentials, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
