package com.bug.hiltrobolectricissue.dependencies

import android.content.Context

interface DynamicFeatureInitializer {
    fun domSomethingWithDynamicFeatureDependency(context: Context)
}