package com.example.android.mvisample.main

import com.example.android.mvisample.base.BaseMviIntent
import com.example.android.mvisample.base.BaseMviViewState
import com.example.android.mvisample.data.Result

sealed class MainActivityActions {

    object LoadData:MainActivityActions()

    object OpenNextActivity :MainActivityActions()

    object DoNothing:MainActivityActions()

}

sealed class MainActivityIntent: BaseMviIntent {

    object DoNothing : MainActivityIntent()

    data class StartNextActivity (var smth:String) : MainActivityIntent()

    object MakeNetworkCallIntent:MainActivityIntent()

}


data class MainActivityViewState(var loading:Boolean,
                                 var list: List<Result>?): BaseMviViewState