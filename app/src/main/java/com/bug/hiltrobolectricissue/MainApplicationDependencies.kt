package com.bug.hiltrobolectricissue

import com.bug.hiltrobolectricissue.dependencies.EarlyInitDependency
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface

interface MainApplicationDependencies {
    fun getEarlyInitDependency(): EarlyInitDependency

    fun getSingletonDependency(): SingletonInterface
}