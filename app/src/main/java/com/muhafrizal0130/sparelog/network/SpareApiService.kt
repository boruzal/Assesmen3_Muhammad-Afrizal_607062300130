package com.muhafrizal0130.sparelog.network

import com.muhafrizal0130.sparelog.model.Spare
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://6844276971eb5d1be03289ca.mockapi.io/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SpareApiService {
    @GET("sparelog")
    suspend fun getSpare(@Query("userId") userId: String): List<Spare>

    @GET("sparelog")
    suspend fun getSpareAll(): List<Spare>

    @FormUrlEncoded
    @POST("sparelog")
    suspend fun postSpare(
        @Field("nama") tempat: String,
        @Field("harga") tanggal: String,
        @Field("imageId") imageId: String,
        @Field("userId") userId: String
    ): Spare

    @DELETE("sparelog/{id}")
    suspend fun deleteSpare(
        @Path("id") id: String
    )

    @FormUrlEncoded
    @PUT("sparelog/{id}")
    suspend fun updateSpare(
        @Path("id") id: String,
        @Field("nama") tempat: String,
        @Field("harga") tanggal: String,
        @Field("imageId") imageId: String,
        @Field("userId") userId: String
    ): Spare


}


object SpareApi {
    val service: SpareApiService = retrofit.create(SpareApiService::class.java)

}

enum class ApiStatus { LOADING, SUCCESS, FAILED }