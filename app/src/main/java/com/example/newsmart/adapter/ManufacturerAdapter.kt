package com.example.newsmart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.model.Manufacturer
import com.example.newsmart.model.Smartphone

typealias OnManufacturerClickListener = (Manufacturer) -> Unit

class ManufacturerAdapter(
    private val manufacturers: List<Manufacturer>,
    private val listener: OnManufacturerClickListener
): RecyclerView.Adapter<ManufacturerAdapter.ManufacturerVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManufacturerVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ManufacturerVH(
            layoutInflater.inflate(R.layout.item_manufacturer,parent,false),
            listener
        )
    }

    override fun onBindViewHolder(holder: ManufacturerVH, position: Int) = holder.bind(manufacturers[position])

    override fun getItemCount(): Int = manufacturers.size

    class ManufacturerVH(
        view: View,
        listener: OnManufacturerClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
        private val tvName = view.findViewById<TextView>(R.id.tvName)

        private lateinit var manufacturer: Manufacturer

        init {
            view.setOnClickListener { listener(manufacturer)}
        }

        fun bind (manufacturer : Manufacturer){
            this.manufacturer = manufacturer
            tvName.text = manufacturer.name
            ivAvatar.setImageResource(manufacturer.coverResId)
        }
    }
}