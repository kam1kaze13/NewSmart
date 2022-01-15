package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.newsmart.data.database.UserConverter
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["user","date","question","coverResId"])
data class Question(
    @TypeConverters(UserConverter::class)
    @ColumnInfo val user: User,
    @ColumnInfo val date: String,
    @ColumnInfo val question : String,
    @ColumnInfo val coverResId : Int
)
