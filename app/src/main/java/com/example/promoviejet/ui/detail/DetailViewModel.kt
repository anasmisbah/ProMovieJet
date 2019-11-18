package com.example.promoviejet.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.utils.DataDummy

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel(){

    fun getMovie(id : String): LiveData<Movie>{
        return movieRepository.getDetailMovie(id,BuildConfig.API_KEY)
    }

    fun getTvShow(id:String): LiveData<TvShow>{
        return movieRepository.getDetailTvShow(id,BuildConfig.API_KEY)
    }
}