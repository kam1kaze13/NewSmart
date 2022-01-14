package com.example.newsmart.presentation

import com.example.newsmart.domain.model.Question

sealed class ScreenStateQuestions{
    data class DataLoaded(val phones: List<Question>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}