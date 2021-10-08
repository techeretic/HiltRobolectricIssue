package com.bug.hiltrobolectricissue.di.modules

import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency2
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object EarlyInitModule {
    @[Provides Singleton]
    fun provideEarlyInitDependency(): EarlyInitDependency {
        return EarlyInitDependency()
    }

    @[Provides Singleton]
    fun provideEarlyInitDependency2(): EarlyInitDependency2 {
        return EarlyInitDependency2()
    }
}
