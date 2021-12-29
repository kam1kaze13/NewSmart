package com.example.newsmart.network

import com.example.newsmart.model.*
import retrofit2.http.GET

interface RestApi {
    @GET("manufacturers")
    suspend fun loadManufacturers() : List<Manufacturer>
    @GET("questions")
    suspend fun loadQuestions() : List<Question>
    @GET("reviews")
    suspend fun loadReviews() : List<Review>
    @GET("servicecenters")
    suspend fun loadServiceCenters() : List<ServiceCenter>
    @GET("smartphones")
    suspend fun loadSmartphones() : List<Smartphone>
    @GET("specifications")
    suspend fun loadSpecifications() : List<Specification>
    @GET("users")
    suspend fun loadUsers() : List<User>

}