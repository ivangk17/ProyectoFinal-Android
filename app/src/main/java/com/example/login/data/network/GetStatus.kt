package com.example.login.data.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetStatus(
    private val api: Api
) {
    suspend fun execute(): Boolean = withContext(Dispatchers.IO) {
        var res = false
         try {
             res = api.getStatus().isSuccessful
        } catch (e: Exception){

        }
        return@withContext res
    }

}