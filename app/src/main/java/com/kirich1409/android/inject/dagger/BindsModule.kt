@file:Suppress("Unused")

package com.kirich1409.android.inject.dagger

import androidx.fragment.app.Fragment
import com.kirich1409.android.inject.MessageFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface BindsModule {

    @[Binds IntoMap FragmentKey(MessageFragment::class)]
    fun bindMessageFragmentToFragment(fragment: MessageFragment): Fragment
}