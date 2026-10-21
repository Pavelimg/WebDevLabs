package com.example.webdevlabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OneFragment : Fragment(R.layout.fragment_one) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val phonesAdapter = PhonesAdapter()
        phonesAdapter.setupPhones(PhonesData.phonesArr)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = phonesAdapter
    }
}
