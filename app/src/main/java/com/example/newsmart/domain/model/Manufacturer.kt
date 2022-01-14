package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Manufacturer(
    val name : String,
    val fullName : String,
    val address : String,
    val coverResId : Int
)
