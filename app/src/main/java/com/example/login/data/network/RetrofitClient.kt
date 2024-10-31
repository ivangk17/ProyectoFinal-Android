package com.example.login.data.network
import com.example.login.data.network.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:3000"

    // con dispositivo fisico
    //private const val BASE_URL = "http:/192.168.0.85:3000/"


    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(UserAgentInterceptor())
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()) // Using Gson converter
        .build()

    val apiService: Api = retrofit.create(Api::class.java)
}
