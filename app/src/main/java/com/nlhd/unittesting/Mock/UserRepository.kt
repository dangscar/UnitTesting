package com.nlhd.unittesting.Mock

import android.util.Log

class UserRepository {

    val users = listOf(
        User(id = 1, name = "John Doe", email = "ldb@fbdn.com",  password = "1234"),
        User(id = 2, name = "Jane Smith", email = "bssb@gmail.com", password = "5678"),
        User(id = 3, name = "Bob Johnson", email = "dangwbee@gmail.com", password = "123")
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {

         val users = users.filter { user ->
             user.email == email
         }

        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            return LOGIN_STATUS.INVALID_USER
        }

    }

}