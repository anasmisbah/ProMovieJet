package com.example.promoviejet.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.data.remote.response.MovieResponse
import com.example.promoviejet.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MovieViewModel(private val movieRepository: MovieRepository) :ViewModel(){

    private val movieResponseLiveData = MutableLiveData<ArrayList<Movie>>()


    fun getMovies():LiveData<List<Movie>> {
       return movieRepository.getMovie(BuildConfig.API_KEY)
    }
}