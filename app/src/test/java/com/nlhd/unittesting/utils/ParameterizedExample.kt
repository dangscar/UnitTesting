package com.nlhd.unittesting.utils

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(val input: String, val expectedOutput: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPallindrome(input)
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}