package com.example.newsmart.model

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Question(
    val user: User,
    val date: String,
    val question : String,
    val coverResId : Int
)
