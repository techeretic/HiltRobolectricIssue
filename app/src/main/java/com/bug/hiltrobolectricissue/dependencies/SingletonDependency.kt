package com.bug.hiltrobolectricissue.dependencies

import android.content.Context
import android.widget.Toast

class SingletonDependency : SingletonInterface {
    override val someValue: Int
        get() = DEFAULT_VALUE

    override fun doSomething(context: Context) {
        Toast.makeText(context, "doSomething in SingletonDependency", Toast.LENGTH_LONG)
            .show()
    }
}

const val DEFAULT_VALUE = 10