package com.bug.hiltrobolectricissue.di.modules

import com.bug.hiltrobolectricissue.dependencies.DynamicFeatureInitializer
import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
object FirstModule {
    @Provides
    fun provideEarlyInitDependency(): EarlyInitDependency {
        return MainApplication.getInstance().earlyInitComponent.getEarlyInitDependency()
    }

    @Provides
    fun provideDynamicFeatureInitializer(): DynamicFeatureInitializer {
        return Class.forName(
            "com.bug.dynamicfeature.DynamicFeatureInitializerImpl"
        ).newInstance() as DynamicFeatureInitializer
    }
}