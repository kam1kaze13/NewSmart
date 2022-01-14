package com.example.newsmart.presentation

import com.example.newsmart.domain.model.Smartphone

sealed class ScreenState{
    data class DataLoaded(val phones: List<Smartphone>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}
