package com.example.newsmart.model

import java.util.*

data class Review(
    val rating : Double,
    val date: String,
    val user: User,
    val advantages : String,
    val limitations : String
)
