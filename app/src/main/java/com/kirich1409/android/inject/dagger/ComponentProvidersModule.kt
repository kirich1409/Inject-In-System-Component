package com.kirich1409.android.inject.dagger

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import dagger.Module
import dagger.multibindings.Multibinds

@Module
interface ComponentProvidersModule {

    @Multibinds
    fun provideActivities(): Map<Class<out Activity>, @JvmSuppressWildcards Activity>

    @Multibinds
    fun provideServices(): Map<Class<out Service>, @JvmSuppressWildcards Service>

    @Multibinds
    fun provideReceivers(): Map<Class<out BroadcastReceiver>, @JvmSuppressWildcards BroadcastReceiver>

    @Multibinds
    fun provideContentProviders(): Map<Class<out ContentProvider>, @JvmSuppressWildcards ContentProvider>
}