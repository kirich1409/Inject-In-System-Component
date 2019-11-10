package com.kirich1409.android.inject.dagger

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A *MapKey* annotation for maps with [Class<out Fragment>][Class] keys.
 *
 * [Dagger Multibindings](https://dagger.dev/multibindings.html)
 */
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentKey(val value: KClass<out Fragment>)
