package com.kirich1409.android.inject.dagger

import androidx.fragment.app.FragmentFactory
import dagger.Component

@Component(modules = [AppModule::class, BindsModule::class])
interface AppComponent {

    val fragmentFactory: FragmentFactory
}