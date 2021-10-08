package com.bug.robolectrictests

import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(TestRobolectricTestRunner::class)
class ExampleUnitTest {
    @Inject
    lateinit var singletonInterface: SingletonInterface

    @Before
    fun setUp() {
        DaggerRobolectricDynamicFeatureComponent.factory()
            .create(
                TestApplication.getInstance().dynamicFeatureDependencies
            )
            .inject(this)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(singletonInterface.someValue, 10)
    }
}