package com.bug.dynamicfeature.di

import com.bug.dynamicfeature.DynamicFeatureInitializerImpl
import com.bug.hiltrobolectricissue.di.DynamicFeatureDependencies
import dagger.Component
import javax.inject.Scope

@[DFM Component(
    dependencies = [DynamicFeatureDependencies::class],
    modules = [DynamicFeatureModule::class]
)]
interface DynamicFeatureComponent {
    @Component.Factory
    interface Factory {
        fun create(
            dynamicFeatureDependencies: DynamicFeatureDependencies
        ): DynamicFeatureComponent
    }

    fun inject(dynamicFeatureInitializerImpl: DynamicFeatureInitializerImpl)
}

@[Scope Retention(AnnotationRetention.RUNTIME)]
annotation class DFM
