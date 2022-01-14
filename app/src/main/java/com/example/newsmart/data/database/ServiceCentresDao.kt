package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Manufacturer
import com.example.newsmart.domain.model.ServiceCenter
import com.example.newsmart.domain.model.Smartphone


@Dao
interface ServiceCentresDao {
    @Query("SELECT * from servicecenter")
    suspend fun getAll(): List<ServiceCenter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(servicecenters: List<ServiceCenter>)
}