package com.example.android.mvisample.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

@SuppressLint("Registered")
open class BaseActivity:AppCompatActivity() {

    val disposable = CompositeDisposable()

    override fun onStop() {
        disposable.dispose()
        super.onStop()
    }

}