package com.example.android.mvisample.di

import com.example.android.mvisample.api.SeatGeekApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit():SeatGeekApi{
        val httpClient = OkHttpClient.Builder()
        val builder = Retrofit.Builder()
                .baseUrl()
                .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder
                .client(httpClient.build())
                .build()
        return retrofit.create(SeatGeekApi::class.java)
    }

}