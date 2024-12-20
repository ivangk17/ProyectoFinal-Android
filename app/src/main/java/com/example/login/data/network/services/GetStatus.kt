package com.example.login.data.network.services

import com.example.login.data.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStatus @Inject constructor(
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