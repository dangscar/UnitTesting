package com.nlhd.unittesting.utils

import java.io.Serializable

class Helper {

    fun isPallindrome(input: String): Boolean {
        var i = 0
        var j = input.length - 1
        while (i < j) {
            if (input[i] != input[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }

    fun isValidatePassword(input: String): Boolean {
        if (input.isEmpty()) {
            return false
        }
        else if (input.length < 6 || input.length > 15) {
            return false
        }
        return true
    }

    fun reverseString(input: String?): String {
        if (input == null) {
            throw IllegalArgumentException("Input cannot be null")
        }
        val charArray = input.toCharArray()
        var i = 0
        var j = charArray.size - 1
        while (i < j) {
            var temp = charArray[i]
            charArray[i] = charArray[j]
            charArray[j] = temp
            i++
            j--
        }
        return charArray.joinToString("")
    }
}