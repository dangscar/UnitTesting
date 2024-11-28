package com.nlhd.unittesting.Mock

import android.annotation.SuppressLint
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var repository: UserRepository

    @SuppressLint("CheckResult")
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(repository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testUserService() {
        val sut = UserService(repository)
        val status = sut.loginUser("999","123456789")

        Assert.assertEquals("Invalid password", status)
    }
}