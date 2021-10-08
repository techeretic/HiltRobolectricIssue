package com.bug.dynamicfeature

import android.content.Context
import com.bug.dynamicfeature.di.DaggerDynamicFeatureComponent
import com.bug.hiltrobolectricissue.di.DynamicFeatureDependencies
import com.bug.hiltrobolectricissue.dependencies.DynamicFeatureInitializer
import com.bug.hiltrobolectricissue.MainApplication
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import dagger.hilt.EntryPoints
import javax.inject.Inject

class DynamicFeatureInitializerImpl : DynamicFeatureInitializer {
    @Inject
    lateinit var dynamicFeatureDependency: DynamicFeatureDependency
    @Inject
    lateinit var singletonDependency: SingletonInterface

    init {
        DaggerDynamicFeatureComponent.factory()
            .create(
                EntryPoints.get(MainApplication.getInstance(), DynamicFeatureDependencies::class.java)
            )
            .inject(this)
    }
    override fun domSomethingWithDynamicFeatureDependency(context: Context) {
        dynamicFeatureDependency.doSomething(context)
        singletonDependency.doSomething(context)
    }
}