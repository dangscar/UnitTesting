package com.nlhd.unittesting.Coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilTest {

    @get:Rule //Excutes before every test
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testGetUser() {

        val util = Util(dispatcher = mainCoroutineRule.testDispatcher)
        runTest {
            util.getAddressDetail()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(true, util.globalArg)
        }


    }
}