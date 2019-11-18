package com.example.promoviejet.ui.detail.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.request.RequestOptions
import com.example.promoviejet.BuildConfig
import com.example.promoviejet.R
import com.example.promoviejet.data.local.entity.TvShow
import com.example.promoviejet.ui.detail.DetailViewModel
import com.example.promoviejet.utils.EXTRA_TVSHOW
import com.example.promoviejet.utils.GlideApp
import com.example.promoviejet.viewmodel.ViewModelFactory

import kotlinx.android.synthetic.main.activity_detail_tv_show.*
import kotlinx.android.synthetic.main.content_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory.getInstance(this.application)).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val tvShowId :String?= intent.getStringExtra(EXTRA_TVSHOW)
        tvShowId?.let {
            viewModel.getTvShow(it).observe(this, Observer {tvShow->
                populateTvShow(tvShow = tvShow )
            })
        }
    }

    private fun populateTvShow(tvShow: TvShow){
        supportActionBar?.title = tvShow.title
        detail_tvShow_title.text = tvShow.title
        detail_tvShow_vote_average.text = tvShow.voteAverage
        detail_tvShow_release_date.text = tvShow.releaseDate
        detail_tvShow_overview.text = tvShow.overview

        GlideApp.with(this)
            .load("${BuildConfig.URL_POSTER}${tvShow.poster}")
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detail_tvShow_poster)
        GlideApp.with(this)
            .load("${BuildConfig.URL_BACKDROP}${tvShow.backDrop}")
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detail_tvShow_backdrop)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
