package com.nlhd.unittesting.Mock

class UserService(private val repository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = repository.loginUser(email, password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "Invalid user"
            LOGIN_STATUS.INVALID_PASSWORD -> "Invalid password"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error"
            LOGIN_STATUS.SUCCESS -> "Login successful"
        }
    }

}