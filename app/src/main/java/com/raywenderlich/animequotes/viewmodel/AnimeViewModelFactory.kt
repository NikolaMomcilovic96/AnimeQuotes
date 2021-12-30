package com.raywenderlich.animequotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.animequotes.repo.AnimeRepo

class AnimeViewModelFactory(private val animeRepo: AnimeRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AnimeViewModel(animeRepo) as T
    }
}