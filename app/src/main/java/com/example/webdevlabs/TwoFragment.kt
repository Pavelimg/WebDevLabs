package com.example.webdevlabs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class TwoFragment : Fragment(R.layout.fragment_two) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        val resetSettingsButton = view.findViewById<Button>(R.id.resetSettingsButton)

        logoutButton.setOnClickListener {
            UserPreferences.saveAutoLogin(requireContext(), false)
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }

        resetSettingsButton.setOnClickListener {
            UserPreferences.clear(requireContext())
            startActivity(Intent(requireContext(), RegistrationActivity::class.java))
            requireActivity().finish()
        }
    }
}
