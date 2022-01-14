package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class ServiceCenter(
    @ColumnInfo val address : String,
    @ColumnInfo val workTime : String
)
