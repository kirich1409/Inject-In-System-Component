@file:Suppress("Unused")

package com.kirich1409.android.inject.dagger

import android.app.Activity
import com.kirich1409.android.inject.MainActivity
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ActivityBindsModule {

    @[Binds IntoMap ActivityKey(MainActivity::class)]
    fun bindMainActivityToActivityForMultiBinding(activity: MainActivity): Activity
}