package com.example.promoviejet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.Resource
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.ui.detail.movie.DetailMovieActivity
import com.example.promoviejet.ui.movie.MovieAdapter
import com.example.promoviejet.ui.movie.MovieViewModel
import com.example.promoviejet.utils.EXTRA_MOVIE
import com.example.promoviejet.utils.toast
import com.example.promoviejet.viewmodel.ViewModelFactory
import com.example.promoviejet.vo.Status
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(this.application)).get(MovieViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movie_adapter = MovieAdapter{
            val intentDetailMovie = Intent(this, DetailMovieActivity::class.java)
            intentDetailMovie.putExtra(EXTRA_MOVIE,it.id)
            startActivity(intentDetailMovie)
        }
        viewModel.getMovieAll().observe(this, Observer {
            Log.d("onCreate",it.toString())
            when(it.status){
                Status.SUCCESS ->{
                    pb_test.visibility = View.INVISIBLE
                    if (it.data != null){
                        val movies = it.data.map { movieTemp ->
                            Movie(movieTemp.id,movieTemp.title,movieTemp.voteAverage,movieTemp.language,movieTemp.overview,movieTemp.releaseDate,movieTemp.poster,movieTemp.backDrop)
                        }
                        movie_adapter.setMovies(movies)
                    }

                    movie_adapter.notifyDataSetChanged()
                }

                Status.LOADING ->{
                    pb_test.visibility = View.VISIBLE
                }

                Status.ERROR ->{
                    pb_test.visibility = View.INVISIBLE

//                    Log.d("active",it.toString())
                    if (it.data != null){
                        val movies = it.data.map { movieTemp ->
                            Movie(movieTemp.id,movieTemp.title,movieTemp.voteAverage,movieTemp.language,movieTemp.overview,movieTemp.releaseDate,movieTemp.poster,movieTemp.backDrop)
                        }
                        movie_adapter.setMovies(movies)
                    }else{
                        toast(it.message?:"unknown error")
                    }
                }
            }
        })




        rv_test.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movie_adapter
        }
    }
}
