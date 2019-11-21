package com.example.promoviejet.data.local

import androidx.paging.DataSource
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

    fun getFavoriteMoviePaged(): DataSource.Factory<Int,Movie>{
        return movieDao.getMovies()
    }

    fun getFavoriteTvShowPaged():DataSource.Factory<Int,TvShow>{
        return movieDao.getTvShows()
    }

    fun addFavoriteMovie(movie:Movie):Boolean{
        val result = movieDao.insertMovie(movie)
        return result > 0
    }

    fun removeFavoriteMovie(movie: Movie):Boolean{
        val result = movieDao.deleteMovie(movie)
        return result > 0
    }

    fun checkFacoriteMovie(id:Int):Movie{
        return movieDao.findFavoriteMovie(id)
    }

    fun addFavoriteTvShow(tvShow:TvShow):Boolean{
        val result =movieDao.insertTvShow(tvShow)
        return result > 0
    }

    fun removeFavoriteTvShow(tvShow: TvShow):Boolean{
        val result =movieDao.deleteTvShow(tvShow)
        return result > 0
    }

    fun checkFacoriteTvShow(id:Int): TvShow {
        return movieDao.findFavoriteTvShow(id)
    }
}