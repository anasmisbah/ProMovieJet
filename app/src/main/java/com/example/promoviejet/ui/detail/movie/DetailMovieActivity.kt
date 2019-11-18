package com.example.promoviejet.ui.detail.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.request.RequestOptions
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.ui.detail.DetailViewModel
import com.example.promoviejet.utils.EXTRA_MOVIE
import com.example.promoviejet.utils.GlideApp
import com.example.promoviejet.viewmodel.ViewModelFactory

import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(this.application)).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val movieId : String? = intent.getStringExtra(EXTRA_MOVIE)
        movieId?.let {
            viewModel.getMovie(it).observe(this,Observer {movie->
                populateMovie(movie = movie)
            })
        }
    }

    private fun populateMovie(movie: Movie) {
        supportActionBar?.title = movie.title
        detail_movie_title.text = movie.title
        detail_movie_vote_average.text = movie.voteAverage
        detail_movie_release_date.text = movie.releaseDate
        detail_movie_overview.text = movie.overview

        GlideApp.with(this)
            .load("${BuildConfig.URL_POSTER}${movie.poster}")
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detail_movie_poster)

        GlideApp.with(this)
            .load("${BuildConfig.URL_BACKDROP}${movie.backDrop}")
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detail_movie_backdrop)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
