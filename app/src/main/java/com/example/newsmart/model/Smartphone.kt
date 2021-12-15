package com.example.newsmart.model

import androidx.annotation.DrawableRes

data class Smartphone(
    val manufacturer: Manufacturer,
    val name : String,
    val price : Double,
    val specifications: Specification,
    val reviews: List<Review>,
    val serviceCenter: List<ServiceCenter>,
    val question: List<Question>,
    val coverResId : Int
)

