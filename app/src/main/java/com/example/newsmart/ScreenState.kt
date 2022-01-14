package com.example.newsmart

import com.example.newsmart.model.Smartphone

sealed class ScreenState{
    data class DataLoaded(val phones: List<Smartphone>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}
