package com.example.android.mvisample.di

import com.example.android.mvisample.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class),
    (AndroidSupportInjectionModule::class),(ActivityBindingModule::class)])
interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

}