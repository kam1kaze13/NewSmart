package com.example.newsmart.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object NetworkService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://demo7338874.mockable.io/")
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .build()

    private val restApi = retrofit.create(RestApi::class.java)

    suspend fun loadManufacturers() = restApi.loadManufacturers()
    suspend fun loadQuestions() = restApi.loadQuestions()
    suspend fun loadReviews() = restApi.loadReviews()
    suspend fun loadServiceCenters() = restApi.loadServiceCenters()
    suspend fun loadSmartphones() = restApi.loadSmartphones()
    suspend fun loadSpecifications() = restApi.loadSpecifications()
    suspend fun loadUsers() = restApi.loadUsers()

}