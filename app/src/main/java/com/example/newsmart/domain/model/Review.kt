package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Review(
    @ColumnInfo val rating : Double,
    @ColumnInfo val date: String,
    @ColumnInfo val user: User,
    @ColumnInfo val advantages : String,
    @ColumnInfo val limitations : String
)
