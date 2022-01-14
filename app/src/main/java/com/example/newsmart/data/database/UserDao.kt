package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Manufacturer
import com.example.newsmart.domain.model.Smartphone
import com.example.newsmart.domain.model.User


@Dao
interface UserDao {
    @Query("SELECT * from user")
    suspend fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)
}