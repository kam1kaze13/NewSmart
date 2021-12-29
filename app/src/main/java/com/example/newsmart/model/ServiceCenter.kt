package com.example.newsmart.model

import kotlinx.serialization.Serializable

@Serializable
data class ServiceCenter(
    val address : String,
    val workTime : String
)
