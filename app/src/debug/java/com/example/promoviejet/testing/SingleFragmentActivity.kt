package com.example.promoviejet.testing

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.promoviejet.R

class SingleFragmentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val content = ViewPager(this)
        val params = ViewPager.LayoutParams()
        params.gravity = Gravity.CENTER
        params.width = ViewPager.LayoutParams.MATCH_PARENT
        params.height = ViewPager.LayoutParams.MATCH_PARENT
        content.id = R.id.home_view_pager
        content.layoutParams = params


        setContentView(content)
    }

    fun setFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .add(R.id.home_view_pager,fragment,"TEST")
            .commit()
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .add(R.id.home_view_pager,fragment,"TEST")
            .commit()
    }
}