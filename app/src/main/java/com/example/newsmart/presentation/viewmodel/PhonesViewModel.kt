package com.example.newsmart.presentation.viewmodel

import android.content.Context
import com.example.audiophile.data.network.NetworkService
import com.example.audiophile.presentation.ScreenState
import com.example.newsmart.data.network.NetworkService
import com.example.newsmart.presentation.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi

class PhonesViewModel
    (
    private val context: Context,
    private val coroutineScope: CoroutineScope
    ) {
    private val _screenState = MutableStateFlow<ScreenState> (ScreenState.Loading)
    val screenState : StateFlow<ScreenState> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.emit(ScreenState.Loading)
                val phones = NetworkService.loadSmartphones()
                _screenState.emit(ScreenState.DataLoaded(phones))
            } catch ( ex: Throwable) {
                _screenState.emit(ScreenState.Error("Ошибка"))
            }
        }
    }
}