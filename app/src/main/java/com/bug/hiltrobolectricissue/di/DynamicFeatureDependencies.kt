package com.bug.hiltrobolectricissue.di

import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[EntryPoint InstallIn(SingletonComponent::class)]
interface DynamicFeatureDependencies {
    fun getSingletonInterface(): SingletonInterface
}