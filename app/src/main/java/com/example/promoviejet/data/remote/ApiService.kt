package com.example.promoviejet.data.remote

import androidx.lifecycle.LiveData
import com.example.promoviejet.data.remote.response.DetailMovieResponse
import com.example.promoviejet.data.remote.response.DetailTvShowResponse
import com.example.promoviejet.data.remote.response.MovieResponse
import com.example.promoviejet.data.remote.response.TvShowRespone
import com.example.promoviejet.utils.ENDPOINT_DETAIL_MOVIE
import com.example.promoviejet.utils.ENDPOINT_DETAIL_TV_SHOW
import com.example.promoviejet.utils.ENDPOINT_GET_MOVIE_NOW_PLAYING
import com.example.promoviejet.utils.ENDPOINT_GET_TV_SHOW
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ENDPOINT_GET_MOVIE_NOW_PLAYING)
    fun getNowPlaying(@Query("api_key") apiKey:String): Call<MovieResponse>

    @GET(ENDPOINT_GET_TV_SHOW)
    fun getTvShow(@Query("api_key") apiKey:String): Call<TvShowRespone>

    @GET("${ENDPOINT_DETAIL_MOVIE}{id}")
    fun getDetailMovie(@Path("id") id : String,@Query("api_key") apiKey: String) : Call<DetailMovieResponse>

    @GET("${ENDPOINT_DETAIL_TV_SHOW}{id}")
    fun getDetailTvShow(@Path("id") id : String,@Query("api_key") apiKey: String) : Call<DetailTvShowResponse>


    @GET(ENDPOINT_GET_MOVIE_NOW_PLAYING)
    fun getMovie(@Query("api_key") apiKey:String): LiveData<ApiResponse<MovieResponse>>
}