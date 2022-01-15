package com.example.newsmart.presentation

import com.example.newsmart.domain.model.Question

sealed class ScreenStateQuestions{
    data class DataLoaded(val phones: List<Question>) : ScreenStateQuestions()
    object Loading : ScreenStateQuestions()
    data class Error(val error: String) : ScreenStateQuestions()
}