package com.example.promoviejet.data

import androidx.lifecycle.LiveData
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow

interface MovieDataSource {

    //untuk halaman movie
    fun getMovie(apiKey:String) : LiveData<List<Movie>>

    //untuk halaman tvshow
    fun getTvShow(apiKey:String) : LiveData<List<TvShow>>

    //untuk detail movie
    fun getDetailMovie(id:String,apiKey: String): LiveData<Movie>

    //untuk detail tvshow
    fun getDetailTvShow(id:String,apiKey: String) : LiveData<TvShow>

    //untuk halaman favorites movie
    fun getFavoritesMovie() : LiveData<List<Movie>>

    //untuk halaman detail movie, set favorite movie
    fun addFavoriteMovie(movie: Movie)

    //untuk halaman detail movie, remove favorite movie
    fun removeFavoriteMovie(movie: Movie)

    //untuk halaman detail movie, check favorite moview
    fun checkFavoriteMovie(id:Int):Movie
    //untuk halaman favorites tvshow
    fun getFavoritesTvShow():LiveData<List<Movie>>

    //untuk halaman detail movie, set favorite movie
    fun addFavoriteTvShow(tvShow: TvShow)

    //untuk halaman detail movie, remove favorite movie
    fun removeFavoriteTvShow(tvShow: TvShow)

    //untuk halaman detail movie, check favorite moview
    fun checkFavoriteTvShow(id:Int):TvShow

}