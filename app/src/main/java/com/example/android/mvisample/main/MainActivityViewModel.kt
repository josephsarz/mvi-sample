package com.example.android.mvisample.main

import android.arch.lifecycle.ViewModel
import com.example.android.mvisample.IMviViewModel
import com.example.android.mvisample.data.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class MainActivityViewModel : ViewModel(), IMviViewModel<MainActivityIntent, MainActivityViewState> {


    private lateinit var disposable: CompositeDisposable
    private var repository: MainActivityRepository = MainActivityRepositoryImpl()

    private val intentsSubject: PublishSubject<MainActivityIntent> = PublishSubject.create()

    init {
        intentsSubject.publish()
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    override fun processIntents(intents: Observable<MainActivityIntent>) {
        intents.subscribe(intentsSubject)
    }

    override fun states(): Observable<MainActivityViewState> {
        return intentsSubject
                .map<MainActivityActions>({ intentsToActions(it) })
                .map<MainActivityViewState>({ actionToState(it) })
    }

    private fun actionToState(it: MainActivityActions): MainActivityViewState {
        val mainActivityViewState = MainActivityViewState(true, null)
        if (it == MainActivityActions.LoadData) {
            var list = listOf<Result>()
            disposable.add(repository.fetchEpisodes()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ list = it.results }))

            if (list.isEmpty()) {

            } else {
                return MainActivityViewState(false, list)
            }

        }

        return mainActivityViewState
    }

    private fun intentsToActions(it: MainActivityIntent): MainActivityActions {

        if (it == MainActivityIntent.DoNothing) {
            // activity is just starting.
        } else if (it == MainActivityIntent.MakeNetworkCallIntent) {
            return MainActivityActions.LoadData

        }

        return MainActivityActions.DoNothing
    }

}