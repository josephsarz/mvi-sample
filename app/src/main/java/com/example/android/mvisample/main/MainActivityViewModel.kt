package com.example.android.mvisample.main

import android.arch.lifecycle.ViewModel
import com.example.android.mvisample.base.IMviViewModel
import com.example.android.mvisample.data.Result
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class MainActivityViewModel:
        ViewModel(),
        IMviViewModel<MainActivityIntent, MainActivityViewState> {

    private var repository: MainActivityRepository = MainActivityRepositoryImpl()

    private val intentsSubject: PublishSubject<MainActivityIntent> = PublishSubject.create()
    private val states: PublishSubject<MainActivityViewState> = PublishSubject.create()

    override fun processIntents(intents: Observable<MainActivityIntent>) {
        intents.subscribe(intentsSubject)
    }

    override fun states(): Observable<MainActivityViewState> {
        return intentsSubject   //Observable<MainActivityIntent>
                .map({ intentsToActions(it) })  //Observable<MainActivityActions>
                //.compose(actionProcessor())   //
                .scan(null, resultToState())
                .distinctUntilChanged()

    }

    private fun resultToState(): BiFunction<MainActivityViewState, in MainActivityViewState, MainActivityViewState>? {

    }

    private fun actionProcessor() =  ObservableTransformer<MainActivityActions, MainActivityViewState> { actions ->
            actions.publish { observableActions ->
                observableActions.flatMap(Function<MainActivityActions,Observable<MainActivityViewState>> {
                    observableActions.ofType(MainActivityActions.LoadData::class.java).compose(repository.fetchEpisodes())
                })
            }
        }

    }

    private fun actionToState(it: MainActivityActions): MainActivityViewState {
        val mainActivityViewState = MainActivityViewState(true, null)
        if (it == MainActivityActions.LoadData) {
            var list = listOf<Result>()
            repository.fetchEpisodes()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ list = it.results })

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