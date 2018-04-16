package com.example.android.mvisample.di

import com.example.android.mvisample.main.MainActivity
import com.example.android.mvisample.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mainActivity(): MainActivity

}
