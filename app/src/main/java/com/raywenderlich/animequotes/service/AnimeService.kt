package com.raywenderlich.animequotes.service

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {

    @GET("api/quotes")
    suspend fun getQuotes(
        @Query("anime") anime: String,
        @Query("character") character: String,
        @Query("quote") quote: String
    ): Response<List<AnimeModel>>
}