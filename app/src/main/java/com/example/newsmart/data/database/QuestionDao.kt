package com.example.newsmart.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsmart.domain.model.Manufacturer
import com.example.newsmart.domain.model.Question
import com.example.newsmart.domain.model.Smartphone


@Dao
interface QuestionDao {
    @Query("SELECT * from question")
    suspend fun getAll(): List<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<Question>)
}