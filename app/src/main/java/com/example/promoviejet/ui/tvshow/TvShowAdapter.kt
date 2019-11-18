package com.example.promoviejet.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.utils.GlideApp
import kotlinx.android.synthetic.main.item_tvshow.view.*

class TvShowAdapter internal constructor(
    val listener:(TvShow) -> Unit
) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var movies = emptyList<TvShow>()

    internal fun setMovies(movies: List<TvShow>){
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tvshow,parent,false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bindItem(movies.get(position),listener)
    }


    inner class TvShowViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(tvShow: TvShow, listener: (TvShow) -> Unit) = with(itemView){
            tv_item_tvshow_title.text = tvShow.title
            tv_item_tvshow_date.text = tvShow.releaseDate
            tv_item_tvshow_description.text = tvShow.overview

            GlideApp.with(itemView.context)
                .load("${BuildConfig.URL_POSTER}${tvShow.poster}")
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(item_tvshow_img_poster)
            setOnClickListener { listener(tvShow) }
        }
    }

}