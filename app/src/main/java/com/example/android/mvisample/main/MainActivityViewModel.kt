package com.example.android.mvisample.main

import android.arch.lifecycle.ViewModel
import com.example.android.mvisample.base.IMviViewModel
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainActivityViewModel
    @Inject constructor(private val repository: MainActivityRepository):
        ViewModel(),
        IMviViewModel<MainActivityIntent, MainActivityViewState> {

    private val intentsSubject: PublishSubject<MainActivityIntent> = PublishSubject.create()
    private val states: PublishSubject<MainActivityViewState> = PublishSubject.create()

    override fun processIntents(intents: Observable<MainActivityIntent>) {
        intents.subscribe(intentsSubject)
    }

    override fun states(): Observable<MainActivityViewState> {
        return intentsSubject   //Observable<MainActivityIntent>
                .map({ intentsToActions(it) })  //Observable<MainActivityActions>
                .compose(actionProcessor())   //Observable<MainActivityResults>
                .scan(MainActivityViewState(true,null),resultToState) //Observable<MainActivityViewState>
                .distinctUntilChanged()
    }

    /**
     * Transforms result to a state that is rendered to the UI
     */
    private val resultToState = BiFunction { previousState:MainActivityViewState, result:MainActivityResult ->

        when(result){
            is MainActivityResult.FetchEventsResult.Success -> {
                previousState.copy(loading = false,eventsResponse = result.eventsResponse)
            }
            is MainActivityResult.FetchEventsResult.Failure -> {
                previousState.copy(loading = false, eventsResponse = null)
            }
            is MainActivityResult.FetchEventsResult.Loading -> {
                previousState.copy(loading = true,eventsResponse = null )
            }

            is MainActivityResult.EventClicked -> {
                previousState.copy(false,null)
            }

        }


    }


    /**
     * Transforms actions to results
     */
    private fun actionProcessor() = ObservableTransformer<MainActivityActions, MainActivityResult> { actions ->
        actions.publish { observableActions ->
            Observable.merge(
                    observableActions.ofType(MainActivityActions.LoadData::class.java)
                            .flatMap({repository.getEvents()}),
                    observableActions.ofType(MainActivityActions.OpenNextActivity::class.java)
                            .flatMap({ Observable.just(MainActivityResult.EventClicked) })
            )
        }
    }

    private fun intentsToActions(it: MainActivityIntent): MainActivityActions {

        return when(it){
            is MainActivityIntent.StartNextActivity -> {
                MainActivityActions.OpenNextActivity
            }
            is MainActivityIntent.FetchEvents -> {
                MainActivityActions.LoadData
            }
            is MainActivityIntent.DoNothing -> {
                MainActivityActions.DoNothing
            }

        }

    }
}


