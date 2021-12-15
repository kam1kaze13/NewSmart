package com.example.newsmart.model

import java.util.*

data class Question(
    val user: User,
    val date: String,
    val question : String,
    val coverResId : Int
)
