package com.example.promoviejet.ui.detail.movie

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.request.RequestOptions
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.ui.detail.DetailViewModel
import com.example.promoviejet.utils.EXTRA_MOVIE
import com.example.promoviejet.utils.GlideApp
import com.example.promoviejet.utils.toast
import com.example.promoviejet.viewmodel.ViewModelFactory

import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(this.application)).get(DetailViewModel::class.java)
    }

    private var isFavorite = false
    lateinit var movieTemp: Movie
    private var menu: Menu?= null

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
                movieTemp = movie
                if(viewModel.checkMovieFavorite(movie.id)) isFavorite = true
                setfavorite()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.nav_favorite,menu)
        this.menu = menu
        setfavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.favorite_menu ->{
                if (isFavorite) removeFromFavorite() else addToFavorite()

                isFavorite = !isFavorite
                setfavorite()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addToFavorite(){
        if (viewModel.addMovieFavorite(movieTemp)) toast("berhasil menambah favorite") else toast("gagal menambah favorite")
    }
    private fun removeFromFavorite(){
        if (viewModel.removeMovieFavorite(movieTemp)) toast("berhasil menghapus favorite") else toast("gagal menghapus favorite")
    }

    private fun setfavorite() {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite_menu)
        if (isFavorite) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_white)
        }
    }
}
