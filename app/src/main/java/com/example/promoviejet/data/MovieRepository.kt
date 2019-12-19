package com.example.promoviejet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.data.local.LocalRepository
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.MovieTemp
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.ApiResponse
import com.example.promoviejet.data.remote.RemoteRepository
import com.example.promoviejet.data.remote.response.MovieResponse
import com.example.promoviejet.utils.ContextProviders
import com.example.promoviejet.vo.Resource

class MovieRepository(private val remoteRepository: RemoteRepository,private val localRepository: LocalRepository,private val coroutineContext: ContextProviders) : MovieDataSource{



    companion object{
        private var  INSTANCE : MovieRepository? = null
        fun getInstance(remoteRepository: RemoteRepository,localRepository: LocalRepository,coroutineContext: ContextProviders): MovieRepository{
            if (INSTANCE == null){
                synchronized(MovieRepository::class.java){
                    INSTANCE = MovieRepository(remoteRepository,localRepository,coroutineContext)
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
    override fun getFavoritesMovie(): LiveData<PagedList<Movie>> {
        return LivePagedListBuilder<Int,Movie>(localRepository.getFavoriteMoviePaged(),20).build()

    }
    override fun addFavoriteMovie(movie: Movie) : Boolean {
        return localRepository.addFavoriteMovie(movie)
    }

    override fun removeFavoriteMovie(movie: Movie) : Boolean {
        return localRepository.removeFavoriteMovie(movie)
    }

    override fun checkFavoriteMovie(id: Int): Movie {
        return localRepository.checkFacoriteMovie(id)
    }

    //favorites tvShow
    override fun getFavoritesTvShow(): LiveData<PagedList<TvShow>> {
        return LivePagedListBuilder<Int,TvShow>(localRepository.getFavoriteTvShowPaged(),20).build()
    }

    override fun addFavoriteTvShow(tvShow: TvShow) : Boolean {
        return localRepository.addFavoriteTvShow(tvShow)
    }

    override fun removeFavoriteTvShow(tvShow: TvShow) : Boolean {
        return localRepository.removeFavoriteTvShow(tvShow)
    }

    override fun checkFavoriteTvShow(id: Int): TvShow {
        return localRepository.checkFacoriteTvShow(id)
    }

    override fun getMovieTemp(apiKey: String): LiveData<Resource<List<MovieTemp>>> {
        return object : NetworkBoundResource<List<MovieTemp>, MovieResponse>(coroutineContext){
            override fun saveCallResult(item: MovieResponse) {
                val movies = item.results
                movies.let { result->
                    val movieTemp = result.map {
                        MovieTemp(it.id.toString(),it.title,it.vote_average.toString(),it.original_language,it.overview,it.release_date,it.poster_path,it.backdrop_path)
                    }

                    localRepository.saveMovieAll(movieTemp)
                }
            }

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> = remoteRepository.getMovie(BuildConfig.API_KEY)


            override fun shouldFetch(data: List<MovieTemp>?): Boolean = data != null

            override fun loadFromDb(): LiveData<List<MovieTemp>> =localRepository.getMovieFromDb()


        }.asLiveData()
    }


}