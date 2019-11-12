package com.kirich1409.android.inject.dagger

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import dagger.Module
import dagger.multibindings.Multibinds

@Module
interface ComponentProvidersModule {

    // Define that a Dagger Component can provide Multibind Map of Activities by class
    @Multibinds
    fun provideActivities(): Map<Class<out Activity>, @JvmSuppressWildcards Activity>

    // Define that a Dagger Component can provide Multibind Map of Service by class
    @Multibinds
    fun provideServices(): Map<Class<out Service>, @JvmSuppressWildcards Service>

    // Define that a Dagger Component can provide Multibind Map of BroadcastReceiver by class
    @Multibinds
    fun provideReceivers(): Map<Class<out BroadcastReceiver>, @JvmSuppressWildcards BroadcastReceiver>

    // Define that a Dagger Component can provide Multibind Map of ContentProvider by class
    @Multibinds
    fun provideContentProviders(): Map<Class<out ContentProvider>, @JvmSuppressWildcards ContentProvider>
}