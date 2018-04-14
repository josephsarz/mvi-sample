package com.example.android.mvisample.main

import com.example.android.mvisample.BaseMviIntent

sealed class MainActivityIntent: BaseMviIntent{

    object DoNothing : MainActivityIntent()

    object StartIntent: MainActivityIntent()

    object MakeNetworkCallIntent:MainActivityIntent()

}