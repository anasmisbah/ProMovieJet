package com.example.promoviejet.ui.movie

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.data.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MovieViewModel( application: Application ,private val movieRepository: MovieRepository) :ViewModel(){

    val contex:Context = application.applicationContext

    fun getMovies():LiveData<List<Movie>> {
       return movieRepository.getMovie(BuildConfig.API_KEY)
    }

    fun getMovieAll() = movieRepository.getMovieTemp(BuildConfig.API_KEY)
}