package com.example.android.mvisample.base

import io.reactivex.Observable

interface IMviViewModel<I : BaseMviIntent, S : BaseMviViewState> {
    fun processIntents(intents: Observable<I>)

    fun states(): Observable<S>
}