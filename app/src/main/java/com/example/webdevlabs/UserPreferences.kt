package com.example.webdevlabs

import android.content.Context

object UserPreferences {
    private const val FILE_NAME = "user_data"
    private const val CONTACT_KEY = "contact"
    private const val PASSWORD_KEY = "password"
    private const val AUTO_LOGIN_KEY = "auto_login"

    private fun preferences(context: Context) =
        context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun saveCredentials(context: Context, contact: String, password: String) {
        preferences(context).edit()
            .putString(CONTACT_KEY, contact)
            .putString(PASSWORD_KEY, password)
            .putBoolean(AUTO_LOGIN_KEY, false)
            .apply()
    }

    fun hasCredentials(context: Context): Boolean {
        val contact = preferences(context).getString(CONTACT_KEY, null)
        val password = preferences(context).getString(PASSWORD_KEY, null)
        return !contact.isNullOrEmpty() && !password.isNullOrEmpty()
    }

    fun credentialsMatch(context: Context, contact: String, password: String): Boolean {
        val savedContact = preferences(context).getString(CONTACT_KEY, "")
        val savedPassword = preferences(context).getString(PASSWORD_KEY, "")
        return contact == savedContact && password == savedPassword
    }

    fun saveAutoLogin(context: Context, enabled: Boolean) {
        preferences(context).edit()
            .putBoolean(AUTO_LOGIN_KEY, enabled)
            .apply()
    }

    fun isAutoLoginEnabled(context: Context): Boolean {
        return preferences(context).getBoolean(AUTO_LOGIN_KEY, false)
    }

    fun clear(context: Context) {
        preferences(context).edit().clear().apply()
    }
}
