package com.bug.hiltrobolectricissue

import android.app.Application
import android.content.Context
import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import com.bug.hiltrobolectricissue.di.components.DaggerEarlyInitComponent
import com.bug.hiltrobolectricissue.di.components.EarlyInitComponent
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

open class MainApplication : Application() {

    lateinit var earlyInitComponent: EarlyInitComponent

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        earlyInitComponent = DaggerEarlyInitComponent.factory().create()
        instanceInternal = this
    }

    companion object {
        private lateinit var instanceInternal: MainApplication

        @JvmStatic
        fun getInstance(): MainApplication {
            return instanceInternal
        }
    }
}