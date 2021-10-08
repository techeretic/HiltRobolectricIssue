package com.bug.hiltrobolectricissue

import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
open class HiltMainApplication : MainApplication() {

    @Inject
    lateinit var earlyInitDependency: EarlyInitDependency

    @Inject
    lateinit var singletonDependency: SingletonInterface

}
