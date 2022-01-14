package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name : String,
    val lastName : String,
    val phone : String,
    val email : String,
    val address : String,
    val coverResId : Int
)
