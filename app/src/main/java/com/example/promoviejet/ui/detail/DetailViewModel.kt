package com.example.promoviejet.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.RemoteRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel(){

    fun getMovie(id : String): LiveData<Movie>{
        return movieRepository.getDetailMovie(id,BuildConfig.API_KEY)
    }

    fun getTvShow(id:String): LiveData<TvShow>{
        return movieRepository.getDetailTvShow(id,BuildConfig.API_KEY)
    }

    fun checkMovieFavorite(id:String):Boolean{
        val movie= movieRepository.checkFavoriteMovie(id.toInt())

        return movie != null
    }

    fun addMovieFavorite(movie: Movie):Boolean{
        return movieRepository.addFavoriteMovie(movie)
    }

    fun removeMovieFavorite(movie: Movie):Boolean{
        return  movieRepository.removeFavoriteMovie(movie)
    }

    fun checkTvShowFavorite(id:String):Boolean{
        val movie= movieRepository.checkFavoriteTvShow(id.toInt())

        return movie != null
    }

    fun addTvShowFavorite(tvShow: TvShow):Boolean{
        return movieRepository.addFavoriteTvShow(tvShow)
    }

    fun removeTvShowFavorite(tvShow: TvShow):Boolean{
        return  movieRepository.removeFavoriteTvShow(tvShow)
    }
}