package com.raywenderlich.animequotes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.animequotes.repo.AnimeRepo
import com.raywenderlich.animequotes.service.AnimeModel
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeViewModel(private val animeRepo: AnimeRepo) : ViewModel() {

    var animeData: MutableLiveData<Response<List<AnimeModel>>> = MutableLiveData()

    fun getCustomQuotes(anime: String, character: String, quote: String) {
        viewModelScope.launch {
            val response = animeRepo.getQuotes(anime, character, quote)
            animeData.value = response
        }
    }
}