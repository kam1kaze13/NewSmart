package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.newsmart.data.database.UserConverter
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["date"])
data class Review(
    @ColumnInfo val rating : Double,
    @ColumnInfo val date: String,
    @TypeConverters(UserConverter::class)
    @ColumnInfo val user: User,
    @ColumnInfo val advantages : String,
    @ColumnInfo val limitations : String
)
