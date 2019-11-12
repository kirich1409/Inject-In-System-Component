@file:Suppress("Unused")

package com.kirich1409.android.inject.dagger

import androidx.fragment.app.Fragment
import com.kirich1409.android.inject.MessageFragment
import com.kirich1409.android.inject.dagger.keys.FragmentKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Dagger module for specify binding between [Fragment] subclasses and [Fragment] to Multibinding map.
 */
@Module
interface FragmentBindsModule {

    @[Binds IntoMap FragmentKey(MessageFragment::class)]
    fun bindMessageFragmentToFragmentForMultiBinding(fragment: MessageFragment): Fragment
}