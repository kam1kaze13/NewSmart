package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Specification(
    @ColumnInfo val warranty : String,
    @ColumnInfo val color : String,
    @ColumnInfo val operationSystem : String,
    @ColumnInfo val display : String,
    @ColumnInfo val processor : String,
    @ColumnInfo val camera : String
)
