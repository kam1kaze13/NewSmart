package com.example.newsmart.data.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var db: NewSmartDatabase? = null

    fun provideDatabase(context: Context): NewSmartDatabase {
        return db ?: Room.databaseBuilder(
            context.applicationContext,
            NewSmartDatabase::class.java, "newsmart_app_database"
        )
            .build()
            .also { db = it }
    }
}