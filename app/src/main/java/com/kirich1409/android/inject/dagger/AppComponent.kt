package com.kirich1409.android.inject.dagger

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import androidx.fragment.app.FragmentFactory
import dagger.Component
import javax.inject.Provider

@Component(
    modules = [
        AppModule::class,
        ComponentProvidersModule::class,
        FragmentBindsModule::class,
        ActivityBindsModule::class
    ]
)
interface AppComponent {

    fun inject(factory: InjectComponentFactory)

    val activityProviders: Map<Class<out Activity>, @JvmSuppressWildcards Provider<Activity>>

    val serviceProviders: Map<Class<out Service>, @JvmSuppressWildcards Provider<Service>>

    val receiverProviders: Map<Class<out BroadcastReceiver>, @JvmSuppressWildcards Provider<BroadcastReceiver>>

    val contentProviderProviders: Map<Class<out ContentProvider>, @JvmSuppressWildcards Provider<ContentProvider>>

    val fragmentFactory: FragmentFactory
}