package com.bug.robolectrictests

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.pluginapi.config.GlobalConfigProvider

open class TestRobolectricTestRunner(cls: Class<*>) : RobolectricTestRunner(cls),
    GlobalConfigProvider {

    // We need it this way in our project
    override fun buildGlobalConfig(): Config {
        return Config.Builder()
            // This is a little hokey but it allows us to set our Robolectric SDK version in a single place.
            .setSdk(Config.Builder().setSdk(28).build().sdk[0])
            .setApplication(TestApplication::class.java)
            .build()
    }
    override fun get(): Config = Config.Builder().setSdk(28).build()
}