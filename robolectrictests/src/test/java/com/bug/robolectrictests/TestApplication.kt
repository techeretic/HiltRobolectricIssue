package com.bug.robolectrictests

import android.content.Context
import com.bug.hiltrobolectricissue.MainApplication
import com.bug.hiltrobolectricissue.di.DynamicFeatureDependencies
import dagger.hilt.EntryPoints

class TestApplication : MainApplication() {

    lateinit var dynamicFeatureDependencies: DynamicFeatureDependencies

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instanceInternal = this
    }

    override fun onCreate() {
        super.onCreate()
        dynamicFeatureDependencies = EntryPoints.get(this, DynamicFeatureDependencies::class.java)
    }

    companion object {
        private lateinit var instanceInternal: TestApplication

        @JvmStatic
        fun getInstance(): TestApplication {
            return instanceInternal
        }
    }
}