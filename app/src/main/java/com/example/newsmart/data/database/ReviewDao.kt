package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Manufacturer
import com.example.newsmart.domain.model.Review
import com.example.newsmart.domain.model.Smartphone


@Dao
interface ReviewDao {
    @Query("SELECT * from review")
    suspend fun getAll(): List<Review>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(reviews: List<Review>)
}