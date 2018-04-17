package com.example.android.mvisample.main

import io.reactivex.ObservableSource

interface MainActivityRepository {
    fun getEvents():ObservableSource<out MainActivityResult>?
}