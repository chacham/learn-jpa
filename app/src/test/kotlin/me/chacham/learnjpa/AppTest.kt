package me.chacham.learnjpa

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull


class AppTest {
    @Test
    fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}
