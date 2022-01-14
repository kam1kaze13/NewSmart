package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["user","date","question","coverResId"])
data class Question(
    @ColumnInfo val user: User,
    @ColumnInfo val date: String,
    @ColumnInfo val question : String,
    @ColumnInfo val coverResId : Int
)
