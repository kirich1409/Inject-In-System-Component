@file:Suppress("Unused")

package com.kirich1409.android.inject.dagger

import android.app.Activity
import com.kirich1409.android.inject.MainActivity
import com.kirich1409.android.inject.dagger.keys.ActivityKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Dagger module for specify binding between Activity subclasses and Activity to Multibinding map.
 */
@Module
interface ActivityBindsModule {

    @[Binds IntoMap ActivityKey(MainActivity::class)]
    fun bindMainActivityToActivityForMultiBinding(activity: MainActivity): Activity
}