package com.example.android.mvisample.main

import com.example.android.mvisample.BaseMviViewState
import com.example.android.mvisample.data.Result

data class MainActivityViewState(var loading:Boolean, var list: List<Result>?):BaseMviViewState