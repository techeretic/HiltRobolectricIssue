package com.bug.dynamicfeature

import android.content.Context
import android.widget.Toast

class DynamicFeatureDependency: DynamicFeatureInterface {
    override val someValue: Int
        get() = 20

    override fun doSomething(context: Context) {
        Toast.makeText(context, "doSomething in DynamicFeatureDependency", Toast.LENGTH_LONG)
            .show()
    }
}
