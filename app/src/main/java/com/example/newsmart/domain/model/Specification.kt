package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Specification(
    val warranty : String,
    val color : String,
    val operationSystem : String,
    val display : String,
    val processor : String,
    val camera : String
)
