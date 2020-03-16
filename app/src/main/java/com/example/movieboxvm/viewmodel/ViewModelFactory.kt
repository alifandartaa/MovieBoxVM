package com.example.movieboxvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieboxvm.data.MovieRepository
import com.example.movieboxvm.di.Injection
import com.example.movieboxvm.ui.movie.MovieViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return when{
                modelClass.isAssignableFrom(MovieViewModel::class.java)->{
                    MovieViewModel(mMovieRepository)  as T
                }
            else -> throw Throwable("Unknown Viewmodel class : " + modelClass.name)
        }

    }
}