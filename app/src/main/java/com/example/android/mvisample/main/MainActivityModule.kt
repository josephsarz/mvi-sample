package com.example.android.mvisample.main

import dagger.Module
import dagger.Provides
import io.reactivex.ObservableTransformer

@Module
class MainActivityModule {

    @Provides
    fun providesMainActivityRepository():MainActivityRepository {
        return object : MainActivityRepository {
            override fun getEvents(): ObservableTransformer<MainActivityActions, MainActivityViewState> {
                return null
            }
        }
    }

}