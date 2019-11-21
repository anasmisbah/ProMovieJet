package com.example.promoviejet.ui.movie


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.Movie
import com.example.promoviejet.utils.GlideApp
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter internal constructor(
    val listener:(Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies = emptyList<Movie>()

    internal fun setMovies(movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(movies.get(position),listener)
    }


     class MovieViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(movie: Movie, listener: (Movie) -> Unit) = with(itemView){
            tv_item_movie_title.text = movie.title
            tv_item_movie_date.text = movie.releaseDate
            tv_item_movie_description.text = movie.overview

            GlideApp.with(itemView.context)
                .load(BuildConfig.URL_POSTER+movie.poster)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(item_image_img_poster)
            setOnClickListener { listener(movie) }
        }
    }

}