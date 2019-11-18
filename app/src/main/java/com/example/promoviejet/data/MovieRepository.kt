package com.example.promoviejet.data

import androidx.lifecycle.LiveData
import com.example.promoviejet.data.local.LocalRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.RemoteRepository

class MovieRepository(private val remoteRepository: RemoteRepository,private val localRepository: LocalRepository) : MovieDataSource{



    companion object{
        private var  INSTANCE : MovieRepository? = null
        fun getInstance(remoteRepository: RemoteRepository,localRepository: LocalRepository): MovieRepository{
            if (INSTANCE == null){
                synchronized(MovieRepository::class.java){
                    INSTANCE = MovieRepository(remoteRepository,localRepository)
                }
            }
            return INSTANCE!!
        }
    }

    override fun getMovie(apiKey: String): LiveData<List<Movie>> {
        return remoteRepository.getMovieNowPlaying(apiKey)
    }

    override fun getTvShow(apiKey: String): LiveData<List<TvShow>> {
        return remoteRepository.getTvShow(apiKey)
    }

    override fun getDetailMovie(id: String, apiKey: String): LiveData<Movie> {
        return remoteRepository.getDetailMovie(id,apiKey)
    }

    override fun getDetailTvShow(id: String, apiKey: String): LiveData<TvShow> {
        return remoteRepository.getDetailTvShow(id,apiKey)
    }

    //favorites Movie
    override fun getFavoritesMovie(): LiveData<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun addFavoriteMovie(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeFavoriteMovie(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkFavoriteMovie(id: Int): Movie {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //favorites tvShow
    override fun getFavoritesTvShow(): LiveData<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFavoriteTvShow(tvShow: TvShow) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeFavoriteTvShow(tvShow: TvShow) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkFavoriteTvShow(id: Int): TvShow {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}