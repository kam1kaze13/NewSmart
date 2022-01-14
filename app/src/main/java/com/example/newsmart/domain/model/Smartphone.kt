package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
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

