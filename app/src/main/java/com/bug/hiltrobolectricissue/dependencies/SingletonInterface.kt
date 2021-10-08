package com.bug.hiltrobolectricissue.dependencies

import android.content.Context

interface SingletonInterface {
    val someValue: Int

    fun doSomething(context: Context)
}