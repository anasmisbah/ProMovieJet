package com.example.promoviejet.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.data.remote.response.DetailMovieResponse
import com.example.promoviejet.data.remote.response.DetailTvShowResponse
import com.example.promoviejet.data.remote.response.MovieResponse
import com.example.promoviejet.data.remote.response.TvShowRespone
import com.example.promoviejet.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    private val  apiClient =ApiClient.provideApiClient()



    companion object{
        private var  INSTANCE : RemoteRepository? = null
        fun getInstance(): RemoteRepository{
            if (INSTANCE == null){
                INSTANCE = RemoteRepository()
            }

            return INSTANCE!!
        }
    }

    fun getMovieNowPlaying(apiKey:String): LiveData<List<Movie>> {
        EspressoIdlingResource.increment()
         val nowPlayingMovieLiveData = MutableLiveData<List<Movie>>()
        apiClient.getNowPlaying(apiKey)
            .enqueue(object :Callback<MovieResponse>{
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("RemoteRepository",t.message)
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    EspressoIdlingResource.decrement()
                    response.body()?.let {
                        val movies = it.results.map {
                            result -> Movie(result.id.toString(),result.title,result.vote_average.toString(),result.original_language,result.overview,result.release_date,result.poster_path)
                        }
                        nowPlayingMovieLiveData.value = movies
                    }
                }

            })
        return nowPlayingMovieLiveData
    }

    fun getTvShow(apiKey:String) : LiveData<List<TvShow>>{
        Log.d("Disini","disini")
        EspressoIdlingResource.increment()
        val tvShowLiveData = MutableLiveData<List<TvShow>>()
        apiClient.getTvShow(apiKey)
            .enqueue(object : Callback<TvShowRespone>{
                override fun onFailure(call: Call<TvShowRespone>, t: Throwable) {
                    Log.d("RemoteRepository",t.message)
                }

                override fun onResponse(
                    call: Call<TvShowRespone>,
                    response: Response<TvShowRespone>
                ) {
                    EspressoIdlingResource.decrement()
                   response.body()?.let {
                       val tvShows = it.results.map {
                           resultTvShow -> TvShow(resultTvShow.id.toString(),resultTvShow.original_name,resultTvShow.vote_average.toString(),
                           resultTvShow.original_language,resultTvShow.overview,resultTvShow.first_air_date,resultTvShow.poster_path)
                       }
                       tvShowLiveData.value = tvShows
                       Log.d("Disini","disini berhasil")
                   }
                }

            })
        return tvShowLiveData
    }

    fun getDetailMovie(id:String,apiKey: String) : LiveData<Movie>{
        EspressoIdlingResource.increment()
        val movieLiveData = MutableLiveData<Movie>()
        apiClient.getDetailMovie(id,apiKey)
            .enqueue(object : Callback<DetailMovieResponse>{
                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    Log.d("RemoteRepository",t.message)
                }

                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    EspressoIdlingResource.decrement()
                    response.body()?.let {
                        val movieRes = Movie(it.id.toString(),it.title,it.vote_average.toString(),it.original_language,it.overview,it.release_date,it.poster_path,it.backdrop_path)
                        movieLiveData.value = movieRes
                    }
                }

            })
        return movieLiveData
    }

    fun getDetailTvShow(id: String,apiKey: String): LiveData<TvShow>{
        EspressoIdlingResource.increment()
        val tvShowLiveData = MutableLiveData<TvShow>()

        apiClient.getDetailTvShow(id,apiKey)
            .enqueue(object : Callback<DetailTvShowResponse>{
                override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                    Log.d("RemoteRepository",t.message)
                }

                override fun onResponse(
                    call: Call<DetailTvShowResponse>,
                    response: Response<DetailTvShowResponse>
                ) {
                    EspressoIdlingResource.decrement()
                    response.body()?.let {
                        val tvShowRes = TvShow(it.id.toString(),it.name,it.vote_average.toString(),it.original_language,it.overview,it.first_air_date,it.poster_path,it.backdrop_path)
                        tvShowLiveData.value = tvShowRes
                    }
                }

            })
        return tvShowLiveData
    }
}