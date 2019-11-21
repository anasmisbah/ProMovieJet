package com.example.promoviejet.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.ui.tvshow.TvShowAdapter

class FavoriteTvShowPagedAdapter (private val listener: (TvShow)-> Unit):
    PagedListAdapter<TvShow, TvShowAdapter.TvShowViewHolder>(tvShowDiffCallback){

    companion object {
        val tvShowDiffCallback = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowAdapter.TvShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tvshow,parent,false)
        return TvShowAdapter.TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindItem(it,listener)
        }
    }
}