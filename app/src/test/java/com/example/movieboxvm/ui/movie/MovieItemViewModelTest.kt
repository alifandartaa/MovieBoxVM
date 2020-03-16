package com.example.movieboxvm.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieItemViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun givenMovieViewModelWhenGetMoviesLengthThenReturnTwo() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}