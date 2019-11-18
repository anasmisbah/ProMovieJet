package com.example.promoviejet.ui.tvshow


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.promoviejet.R
import com.example.promoviejet.ui.detail.tvshow.DetailTvShowActivity
import com.example.promoviejet.utils.EXTRA_TVSHOW
import com.example.promoviejet.utils.invisible
import com.example.promoviejet.utils.visible
import com.example.promoviejet.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_showk.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this,ViewModelFactory.getInstance(activity?.application)).get(TvShowViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_showk, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
//            val viewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
            tvShowBar.visible()
            val tvShowAdapter = TvShowAdapter{
                val intenttvShowMovie = Intent(context, DetailTvShowActivity::class.java)
                intenttvShowMovie.putExtra(EXTRA_TVSHOW,it.id)
                startActivity(intenttvShowMovie)
            }
             viewModel.getTvShow().observe(this, Observer {
                 tvShowBar.invisible()
                tvShowAdapter.setMovies(it)
                 tvShowAdapter.notifyDataSetChanged()
            })

            rv_tvshow.layoutManager = LinearLayoutManager(context)
            rv_tvshow.setHasFixedSize(true)
            rv_tvshow.adapter = tvShowAdapter
        }
    }


}
