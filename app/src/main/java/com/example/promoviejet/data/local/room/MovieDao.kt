package com.example.promoviejet.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.MovieTemp
import com.example.promoviejet.data.local.entity.TvShow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie) :Long

    @Delete
    fun deleteMovie(movie : Movie):Int

    @Query("SELECT * FROM Movie")
    fun getMovies(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM Movie WHERE id = (:id)")
    fun findFavoriteMovie(id:Int) : Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: TvShow) :Long

    @Delete
    fun deleteTvShow(tvShow: TvShow) :Int

    @Query("SELECT * FROM TvShow")
    fun getTvShows(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM TvShow WHERE id = (:id)")
    fun findFavoriteTvShow(id:Int) : TvShow

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovieAll(movie: List<MovieTemp?>)

    @Query("SELECT * FROM movietemp")
    fun getMovieAll(): LiveData<List<MovieTemp>>
}