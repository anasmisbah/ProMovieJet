package com.example.promoviejet.ui.favorite

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.example.promoviejet.R
import com.example.promoviejet.ui.home.HomeActivity
import com.example.promoviejet.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteTvShowFragmentTest{

    @Rule
    @JvmField val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadFavoriteTvShow(){
        Espresso.onView(ViewMatchers.withId(R.id.home_view_pager)).perform(ViewActions.swipeLeft())
        Espresso.onView(ViewMatchers.withId(R.id.home_view_pager)).perform(ViewActions.swipeLeft())
        Espresso.onView(ViewMatchers.withId(R.id.home_view_pager)).perform(ViewActions.swipeLeft())
        Espresso.onView(ViewMatchers.withId(R.id.rv_favorite_tvshow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}