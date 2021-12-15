package com.example.newsmart.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.model.Smartphone

typealias OnPhoneClickListener = (Smartphone) -> Unit

class PhoneAdapter(
    private val phones : List<Smartphone>,
    private val listener : OnPhoneClickListener
): RecyclerView.Adapter<PhoneAdapter.PhoneVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PhoneVH(
            layoutInflater.inflate(R.layout.item_phone,parent,false),
            listener
        )
    }

    override fun onBindViewHolder(holder: PhoneVH, position: Int) = holder.bind(phones[position])

    override fun getItemCount(): Int = phones.size

    class PhoneVH(
        view : View,
        listener : OnPhoneClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvDescription = view.findViewById<TextView>(R.id.tvDescr)

        private lateinit var phone : Smartphone

        init {
            view.setOnClickListener { listener(phone)}
        }

        @SuppressLint("SetTextI18n")
        fun bind (phone : Smartphone){
            this.phone = phone
            tvName.text = phone.manufacturer.toString() + phone.name
            tvDescription.text = phone.price.toString()
            ivAvatar.setImageResource(phone.coverResId)
        }
    }
}