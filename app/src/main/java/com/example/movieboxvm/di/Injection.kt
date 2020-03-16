package com.example.movieboxvm.di

import android.content.Context
import com.example.movieboxvm.data.MovieRepository
import com.example.movieboxvm.data.source.remote.RemoteDataSource
import com.example.movieboxvm.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : MovieRepository {
        val remoteRepository = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteRepository)
    }
}