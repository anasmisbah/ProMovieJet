package com.example.promoviejet.data.local

import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.local.room.MovieDao

class LocalRepository (private val movieDao: MovieDao){
    companion object{
        private var  INSTANCE : LocalRepository? = null
        fun getInstance(movieDao: MovieDao): LocalRepository{
            if (INSTANCE == null){
                INSTANCE = LocalRepository(movieDao)
            }

            return INSTANCE!!
        }
    }

    fun addFavoriteMovie(movie:Movie):Boolean{

        movieDao.insertMovie(movie)


        return true
    }

    fun removeFavoriteMovie(movie: Movie):Boolean{

        movieDao.deleteMovie(movie)

        return true
    }

    fun checkFacoriteMovie(id:Int):Movie{
        val movie = movieDao.findFavoriteMovie(id)

        return movie

    }

    fun addFavoriteTvShow(tvShow:TvShow):Boolean{

        movieDao.insertTvShow(tvShow)


        return true
    }

    fun removeFavoriteTvShow(tvShow: TvShow):Boolean{

        movieDao.deleteTvShow(tvShow)

        return true
    }

    fun checkFacoriteTvShow(id:Int): TvShow {
        val tvShow = movieDao.findFavoriteTvShow(id)

        return tvShow

    }


}