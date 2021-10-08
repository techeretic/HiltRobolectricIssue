package com.bug.robolectrictests

import com.bug.hiltrobolectricissue.MainApplication
import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(MainApplication::class)
interface CustomApplication {
}