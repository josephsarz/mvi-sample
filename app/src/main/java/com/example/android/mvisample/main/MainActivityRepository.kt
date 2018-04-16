package com.example.android.mvisample.main

import io.reactivex.ObservableTransformer

interface MainActivityRepository {
    fun getEvents():ObservableTransformer<MainActivityActions, MainActivityViewState>
}