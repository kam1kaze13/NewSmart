package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Smartphone


@Dao
interface PhoneDao {
    @Query("SELECT * from smartphone")
    suspend fun getAll(): List<Smartphone>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(phones: List<Smartphone>)
}