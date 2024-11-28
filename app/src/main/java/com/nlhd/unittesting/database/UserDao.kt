package com.nlhd.unittesting.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM User WHERE :id = id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM User")
    fun getAllUsersFlow(): Flow<List<User>>
}