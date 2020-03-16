package com.example.movieboxvm.ui.tvshow

import com.example.movieboxvm.ui.movie.MovieViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun givenTvshowViewModelWhenGetTvShowLengthThenReturnTwo() {
        val tvshowEntities = viewModel.getTvShow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities.size)
    }
}