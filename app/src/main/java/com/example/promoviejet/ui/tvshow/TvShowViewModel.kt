package com.example.promoviejet.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.RemoteRepository

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel(){
    fun getTvShow() : LiveData<List<TvShow>> = movieRepository.getTvShow(BuildConfig.API_KEY)
}