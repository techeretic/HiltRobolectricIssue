package com.bug.hiltrobolectricissue.di.modules

import com.bug.hiltrobolectricissue.dependencies.SingletonDependency
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object SingletonModule {

    @[Provides Singleton]
    fun provideSingletonDependency(): SingletonInterface {
        return SingletonDependency()
    }

}