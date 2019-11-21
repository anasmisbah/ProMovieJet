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
import com.example.promoviejet.ui.detail.tvshow.DetailTvShowActivity
import com.example.promoviejet.utils.EXTRA_TVSHOW
import com.example.promoviejet.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteTvShowFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(activity?.application)).get(FavoriteViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tvshowAdapter = FavoriteTvShowPagedAdapter{
            val intenttvShowMovie = Intent(context, DetailTvShowActivity::class.java)
            intenttvShowMovie.putExtra(EXTRA_TVSHOW,it.id)
            startActivity(intenttvShowMovie)
        }

        viewModel.getFavoriteTvShow().observe(this, Observer {
            tvshowAdapter.submitList(it)
            tvshowAdapter.notifyDataSetChanged()
        })

        rv_favorite_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvshowAdapter
        }
    }



}
