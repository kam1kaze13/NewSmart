package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Manufacturer
import com.example.newsmart.domain.model.Smartphone
import com.example.newsmart.domain.model.Specification


@Dao
interface SpecificationDao {
    @Query("SELECT * from specification")
    suspend fun getAll(): List<Specification>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(specifications: List<Specification>)
}