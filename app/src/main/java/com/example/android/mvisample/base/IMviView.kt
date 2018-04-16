package com.example.android.mvisample.base

import io.reactivex.Observable

interface IMviView<I: BaseMviIntent, in S: BaseMviViewState> {

    fun intents(): Observable<I>

    fun render(state: S)

}