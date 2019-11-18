package com.example.promoviejet.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.promoviejet.R
import com.example.promoviejet.ui.movie.MovieFragment
import com.example.promoviejet.ui.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val fragmentAdapter = HomePagerAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(MovieFragment())
        fragmentAdapter.addFragment(TvShowFragment())
        fragmentAdapter.addTitle("Movie")
        fragmentAdapter.addTitle("Tv Show")
        home_view_pager.adapter = fragmentAdapter
        home_tablayout.setupWithViewPager(home_view_pager)
    }
}
