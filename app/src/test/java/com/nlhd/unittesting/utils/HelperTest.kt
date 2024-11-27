package com.nlhd.unittesting.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper
    @Before
    fun setUp() {
        helper = Helper()
        println("Before Every Test Case")
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun isPallindrome() {
        //Act
        val result = helper.isPallindrome("hello")
        //Assert
        assertEquals(false, result)
        println("1")

    }

    @Test
    fun isPallindrome_inputString_level_expectTrue() {
        //Act
        val result = helper.isPallindrome("level")
        //Assert
        assertEquals(true, result)
        println("2")
    }

    @Test
    fun validatePassword() {
        val result = helper.isValidatePassword("")
        assertEquals(false, result)
    }

    fun reverseString() {
        val result = helper.reverseString(null)
        assertEquals("olleh", result)

    }

    @Test(expected = IllegalArgumentException::class)
    fun reverseStringNull() {
        val result = helper.reverseString(null)

    }

}