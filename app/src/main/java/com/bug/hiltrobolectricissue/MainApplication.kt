package com.bug.hiltrobolectricissue

import android.app.Application
import android.content.Context
import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import com.bug.hiltrobolectricissue.di.components.DaggerEarlyInitComponent
import com.bug.hiltrobolectricissue.di.components.EarlyInitComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.android.EarlyEntryPoints
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

open class MainApplication : Application() {

    lateinit var earlyInitComponent: EarlyInitComponent

    lateinit var dependencies: Dependencies

    @[EarlyEntryPoint InstallIn(SingletonComponent::class)]
    interface Dependencies {

        fun earlyInitDependency(): EarlyInitDependency

        fun singletonDependency(): SingletonInterface
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        earlyInitComponent = DaggerEarlyInitComponent.factory().create()
        instanceInternal = this
    }

    override fun onCreate() {
        super.onCreate()

        initializeDependencies()

        dependencies.singletonDependency().doSomething(this)
    }

    protected open fun initializeDependencies() {
        dependencies = EarlyEntryPoints.get(
            this,
            Dependencies::class.java
        )
    }

    companion object {
        private lateinit var instanceInternal: MainApplication

        @JvmStatic
        fun getInstance(): MainApplication {
            return instanceInternal
        }
    }
}