package com.example.promoviejet.ui.detail.tvshow

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.promoviejet.R
import com.example.promoviejet.utils.EXTRA_TVSHOW
import com.example.promoviejet.utils.EspressoIdlingResource
import com.example.promoviejet.utils.FakeDataDummy
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailTvShowActivityTest{
    private val dummyTvShow = FakeDataDummy.generateDummyTvShow().get(0)

    @Rule
    @JvmField val activityRule = object : ActivityTestRule<DetailTvShowActivity>(DetailTvShowActivity::class.java){
        override fun getActivityIntent(): Intent {
            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            val result = Intent(targetContext,DetailTvShowActivity::class.java)
            result.putExtra(EXTRA_TVSHOW,dummyTvShow.id)
            return result
        }
    }

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.detail_tvShow_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_tvShow_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvShow_title)).check(matches(withText(dummyTvShow.title)))

        onView(withId(R.id.detail_tvShow_vote_average)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvShow_vote_average)).check(matches(withText(dummyTvShow.voteAverage)))

        onView(withId(R.id.detail_tvShow_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvShow_release_date)).check(matches(withText(dummyTvShow.releaseDate)))

        onView(withId(R.id.detail_tvShow_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvShow_overview)).check(matches(withText(dummyTvShow.overview)))

    }
}