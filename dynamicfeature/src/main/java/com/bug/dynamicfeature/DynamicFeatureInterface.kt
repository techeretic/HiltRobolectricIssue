package com.bug.dynamicfeature

import android.content.Context

interface DynamicFeatureInterface {
    val someValue: Int

    fun doSomething(context: Context)
}