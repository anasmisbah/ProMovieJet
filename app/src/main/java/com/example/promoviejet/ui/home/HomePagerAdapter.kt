package com.example.promoviejet.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagerAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){

    private val mFragmentList = mutableListOf<Fragment>()
    private val pageTitle = mutableListOf<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int  = mFragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = pageTitle[position]

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }

    fun addTitle(title:String){
        pageTitle.add(title)
    }
}