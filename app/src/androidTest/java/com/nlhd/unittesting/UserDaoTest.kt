package com.nlhd.unittesting

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nlhd.unittesting.database.User
import com.nlhd.unittesting.database.UserDao
import com.nlhd.unittesting.database.UserDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private lateinit var db: UserDatabase
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        ).allowMainThreadQueries()
            .build()

        userDao = db.userDao
    }

    @After
    fun tearDown() {
        db.close()
    }

    val user = User(id = 1, name = "John Doe", age = 56)

    @Test
    fun insertAndRetrieveUser() = runBlocking {

        userDao.upsert(user)
        val retrievedUser = userDao.getUserById(1)
        assert(retrievedUser == user)

    }

    @Test
    fun deleteUser() = runBlocking {
        userDao.delete(user)

    }

    @Test
    fun testFlow() = runBlocking {
        val userFlow = User(id = 3, name = "Alice", age = 28)
        userDao.upsert(userFlow)
        val userFirst = userDao.getAllUsersFlow().first()
        assert(userFirst.isNotEmpty())
    }

}