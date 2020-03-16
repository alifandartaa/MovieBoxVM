package com.example.movieboxvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieboxvm.data.source.entity.MovieEntity
import com.example.movieboxvm.data.source.remote.LoadMovieCallback
import com.example.movieboxvm.data.source.remote.response.MovieItemResponse
import com.example.movieboxvm.data.source.remote.RemoteDataSource

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance
                    ?: MovieRepository(
                        remoteDataSource
                    )
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val moviesResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object :
            LoadMovieCallback {
            override fun onAllMoviesReceived(movieItemResponse: List<MovieItemResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieItemResponse) {
                    val movie =
                        MovieEntity(
                            response.id,
                            response.name,
                            response.overview,
                            response.date,
                            response.photo
                        )
                    movieList.add(movie)
                }
                moviesResult.postValue(movieList)
            }
        })
        return moviesResult
    }

//    override fun getAllMovies(): ArrayList<MovieEntity>{
//        val movieItemResponse = remoteDataSource.getAllMovies()
//        val movieList = ArrayList<MovieEntity>()
//
//        for(response in movieItemResponse){
//            val movie = MovieEntity(
//                response.id,
//                response.name,
//                response.overview,
//                response.date,
//                response.photo
//            )
//            movieList.add(movie)
//        }
//        return movieList
//    }


}