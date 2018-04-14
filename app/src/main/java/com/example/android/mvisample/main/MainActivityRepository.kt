package com.example.android.mvisample.main

import com.example.android.mvisample.data.Episode
import io.reactivex.Observable


interface MainActivityRepository {

    fun fetchEpisodes():Observable<Episode>

}