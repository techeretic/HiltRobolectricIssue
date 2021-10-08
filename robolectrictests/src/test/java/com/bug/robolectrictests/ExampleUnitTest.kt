package com.bug.robolectrictests

import androidx.test.core.app.ApplicationProvider
import com.bug.hiltrobolectricissue.dependencies.SingletonInterface
import com.bug.hiltrobolectricissue.di.DynamicFeatureDependencies
import dagger.hilt.EntryPoints
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(TestRobolectricTestRunner::class)
@HiltAndroidTest
class ExampleUnitTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var singletonInterface: SingletonInterface

    @Before
    fun setUp() {
        DaggerRobolectricDynamicFeatureComponent.factory()
            .create(
                EntryPoints.get(
                    ApplicationProvider.getApplicationContext(),
                    DynamicFeatureDependencies::class.java
                )
            )
            .inject(this)
    }

    @Test
    fun singletonIsUsingTestImplementation() {
        assertEquals(TEST_VALUE, singletonInterface.someValue)
    }
}