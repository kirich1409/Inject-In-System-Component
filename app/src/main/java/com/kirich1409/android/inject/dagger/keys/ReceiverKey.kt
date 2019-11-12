package com.kirich1409.android.inject.dagger.keys

import android.content.BroadcastReceiver
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A *MapKey* annotation for maps with [Class<out BroadcastReceiver>][Class] keys.
 *
 * [Dagger Multibindings](https://dagger.dev/multibindings.html)
 */
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ReceiverKey(@Suppress("unused")val value: KClass<out BroadcastReceiver>)
