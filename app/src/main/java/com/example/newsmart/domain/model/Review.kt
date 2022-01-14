package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val rating : Double,
    val date: String,
    val user: User,
    val advantages : String,
    val limitations : String
)
