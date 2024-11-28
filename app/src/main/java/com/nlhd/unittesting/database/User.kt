package com.nlhd.unittesting.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int
)
