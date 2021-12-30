package com.raywenderlich.animequotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.animequotes.adapter.AnimeRecyclerViewAdapter
import com.raywenderlich.animequotes.databinding.ActivityMainBinding
import com.raywenderlich.animequotes.repo.AnimeRepo
import com.raywenderlich.animequotes.viewmodel.AnimeViewModel
import com.raywenderlich.animequotes.viewmodel.AnimeViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var animeViewModel: AnimeViewModel
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { AnimeRecyclerViewAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        val animeRepo = AnimeRepo()
        val viewModelFactory = AnimeViewModelFactory(animeRepo)
        animeViewModel = ViewModelProvider(this, viewModelFactory)[AnimeViewModel::class.java]
        animeViewModel.getCustomQuotes("Bleach", "Ichigo", "Number One")
        animeViewModel.animeData.observe(this, { response ->
            if (response.isSuccessful) {
                Log.d("ANIME", response.message())
                response.body()?.let { adapter.setData(it) }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}