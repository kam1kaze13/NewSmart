package com.example.newsmart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["name","description","specifications","coverResId"])
data class Smartphone(
    @ColumnInfo val manufacturer: Manufacturer,
    @ColumnInfo val name : String,
    @ColumnInfo val price : Double,
    @ColumnInfo val specifications: Specification,
    @ColumnInfo val reviews: List<Review>,
    @ColumnInfo val serviceCenter: List<ServiceCenter>,
    @ColumnInfo val question: List<Question>,
    @ColumnInfo val coverResId : Int
)

