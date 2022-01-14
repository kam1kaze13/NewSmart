package com.example.newsmart.presentation.viewmodel

import android.content.Context
import com.example.audiophile.data.network.NetworkService
import com.example.audiophile.presentation.ScreenState
import com.example.newsmart.data.database.DatabaseProvider
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
    private val phonesDao = DatabaseProvider.provideDatabase(context).phoneDao()
    private val _screenState = MutableStateFlow<ScreenState> (ScreenState.Loading)
    val screenState : StateFlow<ScreenState> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job = coroutineScope.launch {
            try{
                _screenState.value = ScreenState.Loading
                val phones = try{
                    NetworkService.loadSmartphones().also{
                        phonesDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    phonesDao.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(phones)
            } catch (ex: Throwable){
                _screenState.value = ScreenState.Error("Ошибка!")
            }
        }
    }
}