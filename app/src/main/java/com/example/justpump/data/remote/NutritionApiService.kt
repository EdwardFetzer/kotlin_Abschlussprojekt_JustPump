package com.example.justpump.data.remote

import com.example.justpump.data.model.AllMacros
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://calorieninjas.p.rapidapi.com/v1/"

val client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest: Request = chain.request().newBuilder()
        .addHeader("X-RapidAPI-Key", "26ddb5238cmsh1702ba0121570f8p191623jsnc7f98f6332a9")
        .addHeader("X-RapidAPI-Host", "calorieninjas.p.rapidapi.com")
        .build()
    chain.proceed(newRequest)
}.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NutritionApiService {

    @GET("nutrition")
    suspend fun getMacros(@Query("query") meal: String) : AllMacros

}

object NutritionApi {
    val retrofitService: NutritionApiService by lazy {
        retrofit.create(NutritionApiService::class.java)
    }
}