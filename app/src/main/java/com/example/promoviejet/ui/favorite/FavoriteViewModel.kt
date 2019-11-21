package com.example.promoviejet.ui.favorite

import androidx.lifecycle.ViewModel
import com.example.promoviejet.data.MovieRepository

class FavoriteViewModel (private val movieRepository: MovieRepository):ViewModel(){

    fun getFavoriteMovie()=movieRepository.getFavoritesMovie()

    fun getFavoriteTvShow()=movieRepository.getFavoritesTvShow()
}