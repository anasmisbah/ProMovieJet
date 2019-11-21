package com.example.promoviejet.ui.favorite


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
import com.example.promoviejet.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_movie.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteMovieFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(activity?.application)).get(FavoriteViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = FavoriteMoviePagedAdapter{
            val intentDetailMovie = Intent(context, DetailMovieActivity::class.java)
            intentDetailMovie.putExtra(EXTRA_MOVIE,it.id)
            startActivity(intentDetailMovie)
        }

        viewModel.getFavoriteMovie().observe(this, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })

        rv_favorite_movie.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }






}
