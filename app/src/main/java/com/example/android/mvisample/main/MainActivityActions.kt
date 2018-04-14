package com.example.android.mvisample.main


sealed class MainActivityActions {

    object LoadData:MainActivityActions()

    data class StoreToDb(var list:String):MainActivityActions()

    object DoNothing:MainActivityActions()

}