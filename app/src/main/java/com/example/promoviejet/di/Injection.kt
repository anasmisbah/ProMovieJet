package com.example.promoviejet.di

import android.app.Application
import com.example.promoviejet.data.MovieRepository
import com.example.promoviejet.data.local.LocalRepository
import com.example.promoviejet.data.local.room.MovieDatabase
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.utils.ContextProviders

class Injection {
    companion object{
        fun provideRepository(application: Application) : MovieRepository{

            val remoteRepository = RemoteRepository.getInstance()

            val database = MovieDatabase.getInstance(application)
            val localRepository = LocalRepository.getInstance(database.movieDao())

            return MovieRepository.getInstance(remoteRepository,localRepository, ContextProviders.getInstance())
        }
    }
}