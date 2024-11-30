package com.example.login.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {
    //private const val BASE_URL = "http://10.0.2.2:3000"

    // con dispositivo fisico
    private const val BASE_URL = "http:/192.168.1.3:3000/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(UserAgentInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Get the ApiService instance from Retrofit
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    /*
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(UserAgentInterceptor())
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()) // Using Gson converter
        .build()
*/


}
