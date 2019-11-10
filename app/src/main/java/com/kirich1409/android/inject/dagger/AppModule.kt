package com.kirich1409.android.inject.dagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
object AppModule {

    @Provides
    fun provideFragmentFactory(
        fragmentProviders: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
    ): FragmentFactory {
        return InjectFragmentFactory(fragmentProviders)
    }
}