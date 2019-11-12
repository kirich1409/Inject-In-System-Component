package com.kirich1409.android.inject.dagger

import android.app.Activity
import android.app.AppComponentFactory
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.kirich1409.android.inject.SampleApplication
import javax.inject.Provider

@RequiresApi(Build.VERSION_CODES.P)
// We still need default constructor for AppComponentFactory
class InjectComponentFactory : AppComponentFactory() {

    private lateinit var application: SampleApplication

    private val activityProviders: Map<String, Provider<Activity>> by lazy {
        application.appComponent.activityProviders.mapKeys { (key, _) -> key.name }
    }

    private val serviceProviders: Map<String, Provider<Service>> by lazy {
        application.appComponent.serviceProviders.mapKeys { (key, _) -> key.name }
    }

    private val receiverProviders: Map<String, Provider<BroadcastReceiver>> by lazy {
        application.appComponent.receiverProviders.mapKeys { (key, _) -> key.name }
    }

    private val providerProviders: Map<String, Provider<ContentProvider>> by lazy {
        application.appComponent.contentProviderProviders.mapKeys { (key, _) -> key.name }
    }

    override fun instantiateApplication(cl: ClassLoader, className: String): Application {
        val instantiateApplication = super.instantiateApplication(cl, className)
        this.application = instantiateApplication as SampleApplication
        return instantiateApplication
    }

    override fun instantiateActivity(cl: ClassLoader, className: String, intent: Intent?): Activity {
        return createComponent(activityProviders, className) { super.instantiateActivity(cl, className, intent) }
    }

    override fun instantiateService(cl: ClassLoader, className: String, intent: Intent?): Service {
        return createComponent(serviceProviders, className) { super.instantiateService(cl, className, intent) }
    }

    override fun instantiateReceiver(cl: ClassLoader, className: String, intent: Intent?): BroadcastReceiver {
        return createComponent(receiverProviders, className) { super.instantiateReceiver(cl, className, intent) }
    }

    override fun instantiateProvider(cl: ClassLoader, className: String): ContentProvider {
        return createComponent(providerProviders, className) { super.instantiateProvider(cl, className) }
    }

    private fun <T : Any> createComponent(
        providers: Map<String, Provider<T>>,
        className: String,
        default: () -> T
    ): T {
        val provider = providers[className] ?: run {
            Log.w(TAG, "Can't find Provider for `$className`. The component will be created using Reflection.")
            return default()
        }

        Log.d(TAG, "Create component `$className` using Dagger")
        return provider.get()
    }

    private companion object {

        private const val TAG = "InjectComponentFactory"
    }
}