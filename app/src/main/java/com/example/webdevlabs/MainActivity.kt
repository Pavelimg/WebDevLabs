package com.example.webdevlabs

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val phoneModeButton = findViewById<Button>(R.id.phoneModeButton)
        val emailModeButton = findViewById<Button>(R.id.emailModeButton)
        val contactEditText = findViewById<EditText>(R.id.contactEditText)
        val passwordEditText = findViewById<EditText>(R.id.registrationPasswordEditText)
        val repeatPasswordEditText = findViewById<EditText>(R.id.repeatPasswordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        var emailMode = true

        phoneModeButton.setOnClickListener {
            emailMode = false
            contactEditText.hint = getString(R.string.phone_hint)
            contactEditText.inputType = InputType.TYPE_CLASS_PHONE

            phoneModeButton.backgroundTintList = getColorStateList(R.color.primary)
            phoneModeButton.setTextColor(getColor(R.color.white))
            emailModeButton.backgroundTintList = getColorStateList(R.color.mode_unselected)
            emailModeButton.setTextColor(getColor(R.color.text_secondary))
        }

        emailModeButton.setOnClickListener {
            emailMode = true
            contactEditText.hint = getString(R.string.email_hint)
            contactEditText.inputType = InputType.TYPE_CLASS_TEXT or
                    InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

            emailModeButton.backgroundTintList = getColorStateList(R.color.primary)
            emailModeButton.setTextColor(getColor(R.color.white))
            phoneModeButton.backgroundTintList = getColorStateList(R.color.mode_unselected)
            phoneModeButton.setTextColor(getColor(R.color.text_secondary))
        }

        registerButton.setOnClickListener {
            val contact = contactEditText.text.toString()
            val password = passwordEditText.text.toString()
            val repeatPassword = repeatPasswordEditText.text.toString()

            if (emailMode && !contact.contains("@")) {
                Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT).show()
            } else if (!emailMode && !contact.contains("+")) {
                Toast.makeText(this, R.string.invalid_phone, Toast.LENGTH_SHORT).show()
            } else if (password.length < 8) {
                Toast.makeText(this, R.string.short_password, Toast.LENGTH_SHORT).show()
            } else if (password != repeatPassword) {
                Toast.makeText(this, R.string.passwords_do_not_match, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
