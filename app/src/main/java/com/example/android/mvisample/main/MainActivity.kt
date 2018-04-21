package com.example.android.mvisample.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.android.mvisample.R
import com.example.android.mvisample.base.BaseActivity
import com.example.android.mvisample.base.IMviView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
        BaseActivity(),
        IMviView<MainActivityIntent, MainActivityViewState> {

    private lateinit var viewModel:MainActivityViewModel

    override fun intents(): Observable<MainActivityIntent> {
        return Observable.just(MainActivityIntent.FetchEvents)
    }

    override fun render(state: MainActivityViewState) {
        //TODO: render the state to UI
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        disposable.add(viewModel.states().subscribe({ render(it) },{ it.printStackTrace() }))
        viewModel.processIntents(intents())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
