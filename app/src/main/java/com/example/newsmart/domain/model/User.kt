package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["name","coverResId"])
data class User(
    @ColumnInfo val name : String,
    @ColumnInfo val lastName : String,
    @ColumnInfo val phone : String,
    @ColumnInfo val email : String,
    @ColumnInfo val address : String,
    @ColumnInfo val coverResId : Int
)
