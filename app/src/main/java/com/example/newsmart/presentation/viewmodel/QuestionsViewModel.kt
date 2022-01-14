package com.example.newsmart.presentation.viewmodel

import android.content.Context
import com.example.audiophile.data.network.NetworkService
import com.example.audiophile.presentation.ScreenState
import com.example.newsmart.data.database.DatabaseProvider
import com.example.newsmart.data.network.NetworkService
import com.example.newsmart.presentation.ScreenStateManufacturers
import com.example.newsmart.presentation.ScreenStateQuestions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi


class QuestionsViewModel (
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val questionsDao = DatabaseProvider.provideDatabase(context).questionDao()
    private val _screenState = MutableStateFlow<ScreenStateQuestions> (ScreenStateQuestions.Loading)
    val screenState : StateFlow<ScreenStateQuestions> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job = coroutineScope.launch {
            try{
                _screenState.value = ScreenStateQuestions.Loading
                val questions = try{
                    NetworkService.loadQuestions().also{
                        questionsDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    questionsDao.getAll()
                }
                _screenState.value = ScreenStateQuestions.DataLoaded(questions)
            } catch (ex: Throwable){
                _screenState.value = ScreenStateQuestions.Error("Ошибка!")
            }
        }
    }
}