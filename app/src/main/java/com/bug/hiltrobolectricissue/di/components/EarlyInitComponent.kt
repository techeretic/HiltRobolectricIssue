package com.bug.hiltrobolectricissue.di.components

import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.di.modules.EarlyInitModule
import dagger.Component
import javax.inject.Singleton

@[Singleton Component(modules = [EarlyInitModule::class])]
interface EarlyInitComponent {
    @Component.Factory
    interface Factory {
        fun create(): EarlyInitComponent
    }

    fun getEarlyInitDependency(): EarlyInitDependency
}
