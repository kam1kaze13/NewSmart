package com.example.newsmart.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.adapter.ManufacturerAdapter
import com.example.newsmart.data.DataSource

class ManufacturersActivity : Activity() {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_ICON_RES_ID = "iconResId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manufacturers)
        val rvManufacturers = findViewById<RecyclerView>(R.id.rvManufacturers)
        rvManufacturers.layoutManager = LinearLayoutManager(this)
        rvManufacturers.adapter = ManufacturerAdapter(DataSource.manufacturers) {
            (name, iconResId) -> val intent = Intent(this, ManufacturersActivity::class.java)
            intent.putExtra(KEY_NAME,name)
            intent.putExtra(KEY_ICON_RES_ID,iconResId)
            startActivity(intent)
        }
    }
}