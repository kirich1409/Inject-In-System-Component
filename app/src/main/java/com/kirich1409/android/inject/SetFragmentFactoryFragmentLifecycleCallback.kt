package com.kirich1409.android.inject

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager

class SetFragmentFactoryFragmentLifecycleCallback(
    private val fragmentFactory: FragmentFactory
) : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentPreAttached(fm: FragmentManager, f: Fragment, context: Context) {
        f.childFragmentManager.fragmentFactory = fragmentFactory
    }

}