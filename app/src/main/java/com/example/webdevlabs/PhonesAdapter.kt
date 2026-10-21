package com.example.webdevlabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhonesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val phonesList = ArrayList<PhoneModel>()

    fun setupPhones(phones: ArrayList<PhoneModel>) {
        phonesList.clear()
        phonesList.addAll(phones)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return phonesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhonesViewHolder) {
            holder.bind(phonesList[position])
        }
    }

    class PhonesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.phoneNameTextView)
        private val priceTextView = itemView.findViewById<TextView>(R.id.phonePriceTextView)
        private val dateTextView = itemView.findViewById<TextView>(R.id.phoneDateTextView)
        private val scoreTextView = itemView.findViewById<TextView>(R.id.phoneScoreTextView)

        fun bind(phone: PhoneModel) {
            nameTextView.text = phone.name
            priceTextView.text = itemView.context.getString(R.string.phone_price, phone.price)
            dateTextView.text = itemView.context.getString(R.string.phone_date, phone.date)
            scoreTextView.text = itemView.context.getString(R.string.phone_score, phone.score)
        }
    }
}
