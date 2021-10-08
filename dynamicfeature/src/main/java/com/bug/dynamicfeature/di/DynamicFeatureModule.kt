package com.bug.dynamicfeature.di

import com.bug.dynamicfeature.DynamicFeatureDependency
import dagger.Module
import dagger.Provides

@Module
object DynamicFeatureModule {
    @Provides
    fun provideDynamicFeatureDependency(): DynamicFeatureDependency {
        return DynamicFeatureDependency()
    }
}