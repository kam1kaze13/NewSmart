package com.example.newsmart.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ServiceCenter(
    val address : String,
    val workTime : String
)
