package com.kirich1409.android.inject

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.kirich1409.android.inject.utils.EmptyActivityLifecycleCallbacks

class SetFragmentFactoryActivityCallback(
    private val fragmentFactory: FragmentFactory
) : EmptyActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.fragmentFactory = fragmentFactory
        }
    }
}