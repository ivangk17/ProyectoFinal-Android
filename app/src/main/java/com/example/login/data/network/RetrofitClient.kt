package com.example.login.data.network
import com.example.login.data.network.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    // CACA
    // con emulador
    private const val BASE_URL = "http:/192.168.0.12:3000"

    // con dispositivo fisico
    //private const val BASE_URL = "http:/192.168.0.85:3000/"

    // Create the Retrofit instance
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // Using Gson converter
        .build()

    // Get the ApiService instance from Retrofit
    val apiService: Api = retrofit.create(Api::class.java)
}
