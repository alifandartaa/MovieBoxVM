package com.example.movieboxvm.data.source.remote

import android.os.Handler
import com.example.movieboxvm.data.source.remote.response.MovieItemResponse
import com.example.movieboxvm.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler()

    companion object{

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper) : RemoteDataSource =
            instance
                ?: synchronized(this) {
            instance
                ?: RemoteDataSource(
                    helper
                )
        }
    }

    fun getAllMovies(callback: LoadMovieCallback){
        handler.postDelayed({callback.onAllMoviesReceived(jsonHelper.loadMovies())},
            SERVICE_LATENCY_IN_MILLIS
        )
    }

}

interface LoadMovieCallback {
    fun onAllMoviesReceived(movieItemResponse: List<MovieItemResponse>)
}
