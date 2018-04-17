package com.example.android.mvisample.main

import com.example.android.mvisample.base.BaseMviIntent
import com.example.android.mvisample.base.BaseMviViewState
import com.example.android.mvisample.data.EventsResponse

sealed class MainActivityIntent: BaseMviIntent {

    object DoNothing : MainActivityIntent()
    data class StartNextActivity (val smth:String) : MainActivityIntent()
    object FetchEvents:MainActivityIntent()

}

sealed class MainActivityActions {

    object LoadData:MainActivityActions()
    object OpenNextActivity :MainActivityActions()
    object DoNothing:MainActivityActions()

}

sealed class MainActivityResult {

    sealed class FetchEventsResult {
        data class Success(val eventsResponse:EventsResponse):MainActivityResult()
        data class Failure(val error:String):MainActivityResult()
        object Loading:MainActivityResult()
    }

    object EventClicked:MainActivityResult()

}

data class MainActivityViewState(var loading:Boolean,
                                 var eventsResponse: EventsResponse?): BaseMviViewState