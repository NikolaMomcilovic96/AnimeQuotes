package com.raywenderlich.animequotes.repo

import com.raywenderlich.animequotes.service.AnimeModel
import com.raywenderlich.animequotes.service.AnimeService
import com.raywenderlich.animequotes.service.RetrofitInstance
import retrofit2.Response

class AnimeRepo {

    suspend fun getQuotes(
        anime: String,
        character: String,
        quote: String
    ): Response<List<AnimeModel>> {
        return RetrofitInstance.api.getQuotes(anime, character, quote)
    }
}