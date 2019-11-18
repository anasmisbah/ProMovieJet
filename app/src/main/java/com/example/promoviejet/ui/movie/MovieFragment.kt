package com.example.promoviejet.ui.movie


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.promoviejet.R
import com.example.promoviejet.ui.detail.movie.DetailMovieActivity
import com.example.promoviejet.utils.EXTRA_MOVIE
import com.example.promoviejet.utils.invisible
import com.example.promoviejet.utils.visible
import com.example.promoviejet.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(activity?.application)).get(MovieViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
//            val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

            movieBar.visible()

            val movie_adapter = MovieAdapter{
                val intentDetailMovie = Intent(context, DetailMovieActivity::class.java)
                intentDetailMovie.putExtra(EXTRA_MOVIE,it.id)
                startActivity(intentDetailMovie)
            }

            viewModel.getMovies().observe(this, Observer {
                movieBar.invisible()
                movie_adapter.setMovies(it)
                movie_adapter.notifyDataSetChanged()
            })


            rv_movies.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movie_adapter
            }

        }
    }


}
