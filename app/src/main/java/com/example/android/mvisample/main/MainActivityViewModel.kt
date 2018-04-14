package com.example.android.mvisample.main

import android.arch.lifecycle.ViewModel
import com.example.android.mvisample.IMviViewModel
import com.example.android.mvisample.data.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class MainActivityViewModel : ViewModel(), IMviViewModel<MainActivityIntent, MainActivityViewState> {


    private lateinit var disposable: Disposable
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


    }

    override fun states(): Observable<MainActivityViewState> {
        return intentsSubject
                //.compose(intentFilter)
                .map<MainActivityActions>(Function<MainActivityIntent, MainActivityActions> {
                    intentsToActions(it)
                })
                //.map(this::actionFromIntent)
                //.compose(actionProcessorHolder.actionProcessor)
                .map<MainActivityViewState>(Function<MainActivityActions, MainActivityViewState> {
                    actionToState(it)
                })
        /*.compose(ObservableTransformer<MainActivityActions, MainActivityViewState>{
            actionToState(it)
        })*/
        // Cache each state and pass it to the reducer to create a new state from
        // the previous cached one and the latest Result emitted from the action processor.
        // The Scan operator is used here for the caching.
        //.scan(TasksViewState.idle(), reducer)
        // When a reducer just emits previousState, there's no reason to call render. In fact,
        // redrawing the UI in cases like this can cause jank (e.g. messing up snackbar animations
        // by showing the same snackbar twice in rapid succession).
        //.distinctUntilChanged()
        // Emit the last one event of the stream on subscription
        // Useful when a View rebinds to the ViewModel after rotation.
        //.replay(1)
        // Create the stream on creation without waiting for anyone to subscribe
        // This allows the stream to stay alive even when the UI disconnects and
        // match the stream's lifecycle to the ViewModel's one.
        //.autoConnect(0)

    }

    private fun actionToState(it: MainActivityActions): MainActivityViewState {
        var mainActivityViewState:MainActivityViewState = MainActivityViewState(true,null)
        if (it==MainActivityActions.LoadData){
            var list = listOf<Result>()
            repository.fetchEpisodes()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        list = it.results
                    })

            if (list.isEmpty()){

            } else {
                return MainActivityViewState(false,list)
            }

        }

        return mainActivityViewState
    }

    private fun intentsToActions(it: MainActivityIntent): MainActivityActions {

        if (it == MainActivityIntent.DoNothing) {
            // activity is just starting.
        } else if (it == MainActivityIntent.MakeNetworkCallIntent){
            return MainActivityActions.LoadData

        }

        return MainActivityActions.DoNothing
    }

}