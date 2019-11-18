package com.example.promoviejet.ui.detail.movie

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.promoviejet.R
import com.example.promoviejet.utils.EXTRA_MOVIE
import com.example.promoviejet.utils.EspressoIdlingResource
import com.example.promoviejet.utils.FakeDataDummy
import kotlinx.android.synthetic.main.content_detail_movie.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailMovieActivityTest{
    private val dummyMovie = FakeDataDummy.generateDummyMovie()[0]

    @Rule @JvmField val activityRule = object : ActivityTestRule<DetailMovieActivity>(DetailMovieActivity::class.java){
        override fun getActivityIntent(): Intent {
            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            val result = Intent(targetContext,DetailMovieActivity::class.java)
            result.putExtra(EXTRA_MOVIE,"475557")
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
        onView(withId(R.id.detail_movie_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_title)).check(matches(withText(dummyMovie.title)))

        onView(withId(R.id.detail_movie_vote_average)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_vote_average)).check(matches(withText(dummyMovie.voteAverage)))

        onView(withId(R.id.detail_movie_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_release_date)).check(matches(withText(dummyMovie.releaseDate)))

        onView(withId(R.id.detail_movie_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_overview)).check(matches(withText(dummyMovie.overview)))

    }
}