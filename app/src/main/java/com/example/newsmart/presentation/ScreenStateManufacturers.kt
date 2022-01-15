package com.example.newsmart.presentation

import com.example.newsmart.domain.model.Manufacturer

sealed class ScreenStateManufacturers{
    data class DataLoaded(val phones: List<Manufacturer>) : ScreenStateManufacturers()
    object Loading : ScreenStateManufacturers()
    data class Error(val error: String) : ScreenStateManufacturers()
}