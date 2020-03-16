package com.example.movieboxvm.data

import androidx.lifecycle.LiveData
import com.example.movieboxvm.data.source.entity.MovieEntity

interface MovieDataSource {
    fun getAllMovies() : LiveData<List<MovieEntity>>
}