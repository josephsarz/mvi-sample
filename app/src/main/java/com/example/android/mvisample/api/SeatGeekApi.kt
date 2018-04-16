package com.example.android.mvisample.api

import com.example.android.mvisample.data.EventsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SeatGeekApi {

    @GET("/events")
    fun events(@Query("client_id") clientId:String):Observable<EventsResponse>

}