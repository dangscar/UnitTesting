package com.nlhd.unittesting.Coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Util(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName() : String {
        delay(6000L)
        return "CheezyCode"
    }

    suspend fun getUser() : String {
        CoroutineScope(dispatcher).launch {
            delay(10000)
            this.cancel()
        }
        return "User - CheezyCode"
    }

    suspend fun getAddress() : String {
        withContext(dispatcher) {
            delay(3000)
            this.cancel()
        }
        return "Address"
    }

    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }

}