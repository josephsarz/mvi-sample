package com.example.android.mvisample;

import com.example.android.mvisample.main.MainActivityRepository;
import com.example.android.mvisample.main.MainActivityRepositoryImpl;
import com.example.android.mvisample.main.MainActivityViewState;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class Test {
    void ss() {
        MainActivityRepository repo = new MainActivityRepositoryImpl();

        repo.fetchEpisodes()
                .map(new Function<String, MainActivityViewState>() {

                    @Override
                    public MainActivityViewState apply(String s) {
                        MainActivityViewState mainActivityViewState = new MainActivityViewState();
                        return mainActivityViewState;

                    }
                })
                .compose(new ObservableTransformer<MainActivityViewState, Object>() {
                    @Override
                    public ObservableSource<Object> apply(Observable<MainActivityViewState> upstream) {
                        return null;
                    }
                })
                .scan(null,new BiFunction<MainActivityViewState, MainActivityViewState, MainActivityViewState>() {
                    @Override
                    public MainActivityViewState apply(MainActivityViewState mainActivityViewState, MainActivityViewState mainActivityViewState2) throws Exception {
                        return null;
                    }
                })
                .subscribe();

    }

}
