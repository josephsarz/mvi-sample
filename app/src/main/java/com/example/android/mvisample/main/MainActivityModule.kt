package com.example.android.mvisample.main

import dagger.Module
import dagger.Provides
import io.reactivex.ObservableSource

@Module
class MainActivityModule {

    @Provides
    fun providesMainActivityRepository():MainActivityRepository {
        return object : MainActivityRepository {
            override fun getEvents(): ObservableSource<out MainActivityResult>? {
                return null
            }
        }
    }

}