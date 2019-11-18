package com.example.promoviejet.ui.tvshow

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.promoviejet.R
import com.example.promoviejet.ui.home.HomeActivity
import com.example.promoviejet.utils.EspressoIdlingResource
import com.example.promoviejet.utils.RecyclerViewItemCountAssertion
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowFragmentTest{
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
    fun loadTvShow() {
        onView(withId(R.id.home_view_pager)).perform(swipeLeft())
        onView(withId(R.id.rv_tvshow)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).check(RecyclerViewItemCountAssertion(20))
        onView(allOf(withId(R.id.rv_tvshow),isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,click()))
    }
}