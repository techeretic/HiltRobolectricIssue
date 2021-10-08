package com.bug.robolectrictests

import android.content.Context
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import com.bug.hiltrobolectricissue.di.modules.SingletonModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@[Module TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [SingletonModule::class]
)]
object TestSingletonModule {

    @[Provides Singleton]
    fun provideSingletonDependency(): SingletonInterface {
        return object : SingletonInterface {
            override val someValue: Int
                get() = TEST_VALUE

            override fun doSomething(context: Context) {
                // No Op
            }
        }
    }
}

const val TEST_VALUE = 100