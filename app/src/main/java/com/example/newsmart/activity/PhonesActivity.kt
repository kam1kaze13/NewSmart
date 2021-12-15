package com.example.newsmart.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.adapter.PhoneAdapter
import com.example.newsmart.data.DataSource

class PhonesActivity : Activity() {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phones)
        val rvPhones = findViewById<RecyclerView>(R.id.rvPhones)
        rvPhones.layoutManager = LinearLayoutManager(this)
        rvPhones.adapter = PhoneAdapter(DataSource.phones) { (name,description,iconResId) ->
            val intent = Intent(this, PhonesActivity::class.java)
            intent.putExtra(KEY_NAME,name.toString())
            intent.putExtra(KEY_DESCRIPTION,description)
            intent.putExtra(KEY_ICON_RES_ID, iconResId)
            startActivity(intent)
        }
    }
}

