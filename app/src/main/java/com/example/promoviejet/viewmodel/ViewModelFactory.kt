package com.example.promoviejet.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.di.Injection
import com.example.promoviejet.ui.detail.DetailViewModel
import com.example.promoviejet.ui.favorite.FavoriteViewModel
import com.example.promoviejet.ui.movie.MovieViewModel
import com.example.promoviejet.ui.tvshow.TvShowViewModel

class ViewModelFactory(
    private val movieRepository: MovieRepository,
    private val application: Application
) : ViewModelProvider.NewInstanceFactory(){

    companion object{
        private var  INSTANCE : ViewModelFactory? = null
        fun getInstance(application: Application?) : ViewModelFactory{
            return INSTANCE ?: synchronized(ViewModelFactory::class.java){
                ViewModelFactory(Injection.provideRepository(application!!),application)
            }.also { INSTANCE = it }
        }
    }



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(TvShowViewModel::class.java)){
            return TvShowViewModel(movieRepository) as T
        }else if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(application,movieRepository) as T
        }else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(movieRepository) as T
        }else if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
            return FavoriteViewModel(movieRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}