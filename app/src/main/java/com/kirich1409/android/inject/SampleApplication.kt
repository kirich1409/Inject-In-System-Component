package com.kirich1409.android.inject

import android.app.Application
import com.kirich1409.android.inject.dagger.AppComponent
import com.kirich1409.android.inject.dagger.DaggerAppComponent

class SampleApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        registerActivityLifecycleCallbacks(
            SetFragmentFactoryActivityLifecycleCallback(appComponent.fragmentFactory)
        )
    }
}

