package com.apps.samirmisltest.network

import com.apps.samirmisltest.appsecrets.API_SECRET_CODE
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceGenerator {

    companion object{
        private const val BASE_URL = "http://118.179.84.157:8014/"
        private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val apiService: ApiService by lazy {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor {chain ->
                    var request = chain.request()
                    request = request.newBuilder().addHeader("Secret_Code", API_SECRET_CODE).build()
                    chain.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()

            retrofit.create(ApiService::class.java)
        }
    }
}
