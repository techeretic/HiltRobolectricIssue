package com.bug.hiltrobolectricissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bug.hiltrobolectricissue.dependencies.DynamicFeatureInitializer
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dynamicFeatureInitializer: DynamicFeatureInitializer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        dynamicFeatureInitializer.domSomethingWithDynamicFeatureDependency(this)
    }
}