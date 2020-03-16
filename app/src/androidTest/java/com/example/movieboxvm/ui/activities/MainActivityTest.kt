package com.example.movieboxvm.ui.activities

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.movieboxvm.R
import com.example.movieboxvm.ui.movie.MoviesFragment
import com.example.movieboxvm.utils.DataDummy
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class MainActivityTest {

    private val dummyMovies = DataDummy.generateDataDummyMovies()
    private val dummyTvshow = DataDummy.generateDataDummyTvshow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun onCreate() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()))
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detmov_value_name)).check(matches(withText(dummyMovies[0].name)))
    }

    @Test
    fun loadTvshow(){
        onView(withId(R.id.view_pager)).perform(ViewPagerActions.scrollRight())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvshow.size))
    }

    @Test
    fun loadDetailTvshow(){
        onView(withId(R.id.view_pager)).perform(ViewPagerActions.scrollRight())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detshow_value_date)).check(matches(withText(dummyTvshow[0].release)))
    }
}