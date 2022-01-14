package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Manufacturer
import com.example.newsmart.domain.model.Smartphone


@Dao
interface ManufacturerDao {
    @Query("SELECT * from manufacturer")
    suspend fun getAll(): List<Manufacturer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(manufacturers: List<Manufacturer>)
}