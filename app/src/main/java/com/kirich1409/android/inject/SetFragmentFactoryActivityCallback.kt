package com.kirich1409.android.inject

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.kirich1409.android.inject.utils.EmptyActivityLifecycleCallbacks

class SetFragmentFactoryActivityCallback(
    private val fragmentFactory: FragmentFactory
) : EmptyActivityLifecycleCallbacks {

    private val fragmentLifecycleCallbacks = SetFragmentFactoryFragmentCallback(fragmentFactory)

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.apply {
                fragmentFactory = this@SetFragmentFactoryActivityCallback.fragmentFactory
                registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true)
            }
        }
    }

    class SetFragmentFactoryFragmentCallback(
        private val fragmentFactory: FragmentFactory
    ) : FragmentManager.FragmentLifecycleCallbacks() {

        override fun onFragmentPreAttached(fm: FragmentManager, f: Fragment, context: Context) {
            f.childFragmentManager.fragmentFactory = fragmentFactory
        }
    }
}