package com.example.promoviejet.data.local.room

import androidx.room.*
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie : Movie)

    @Query("SELECT * FROM Movie")
    fun getMovies(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id = (:id)")
    fun findFavoriteMovie(id:Int) : Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: TvShow)

    @Delete
    fun deleteTvShow(tvShow: TvShow)

    @Query("SELECT * FROM TvShow")
    fun getTvShows(): List<TvShow>

    @Query("SELECT * FROM TvShow WHERE id = (:id)")
    fun findFavoriteTvShow(id:Int) : TvShow
}