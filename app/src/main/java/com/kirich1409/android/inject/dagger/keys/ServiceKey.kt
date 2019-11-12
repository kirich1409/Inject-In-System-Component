package com.kirich1409.android.inject.dagger.keys

import android.app.Service
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A *MapKey* annotation for maps with [Class<out Service>][Class] keys.
 *
 * [Dagger Multibindings](https://dagger.dev/multibindings.html)
 */
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ServiceKey(@Suppress("unused") val value: KClass<out Service>)
