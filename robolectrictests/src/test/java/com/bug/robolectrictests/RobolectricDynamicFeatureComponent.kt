package com.bug.robolectrictests

import com.bug.dynamicfeature.di.DFM
import com.bug.dynamicfeature.di.DynamicFeatureComponent
import com.bug.dynamicfeature.di.DynamicFeatureModule
import com.bug.hiltrobolectricissue.di.DynamicFeatureDependencies
import dagger.Component

@[DFM Component(
    dependencies = [DynamicFeatureDependencies::class],
    modules = [DynamicFeatureModule::class]
)]
interface RobolectricDynamicFeatureComponent : DynamicFeatureComponent {
    @Component.Factory
    interface Factory {
        fun create(
            dynamicFeatureDependencies: DynamicFeatureDependencies
        ): RobolectricDynamicFeatureComponent
    }

    fun inject(exampleUnitTest: ExampleUnitTest)
}