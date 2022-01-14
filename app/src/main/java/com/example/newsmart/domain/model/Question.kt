package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val user: User,
    val date: String,
    val question : String,
    val coverResId : Int
)
