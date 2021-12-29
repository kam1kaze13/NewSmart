package com.example.newsmart.model

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Review(
    val rating : Double,
    val date: String,
    val user: User,
    val advantages : String,
    val limitations : String
)
