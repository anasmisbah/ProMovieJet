package com.example.promoviejet.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.ui.movie.MovieAdapter
import java.util.*

class FavoriteMoviePagedAdapter(private val listener: (Movie)-> Unit): PagedListAdapter<Movie,MovieAdapter.MovieViewHolder>(movieDiffCallback){

    companion object {
        val movieDiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return MovieAdapter.MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindItem(it,listener)
        }

    }



}