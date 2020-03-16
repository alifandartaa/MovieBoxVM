package com.example.movieboxvm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieboxvm.data.MovieRepository
import com.example.movieboxvm.data.source.entity.MovieEntity

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies() : LiveData<List<MovieEntity>> = movieRepository.getAllMovies()
//    fun getMovies() : List<Movie> = DataDummy.generateDataDummyMovies()
//    companion object{
//        private const val API_KEY = "3148d91de7ab9fa0e608d7be83b7d967"
//    }
//
//    val listMovies = MutableLiveData<ArrayList<MovieItem>>()
//
//    internal fun setMovies(){
//        val client = AsyncHttpClient()
//        val listItems = ArrayList<MovieItem>()
//        val url = "https://api.themoviedb.org/3/discover/movie?api_key=${API_KEY}&language=en-US"
//
//        val posterPath = "https://image.tmdb.org/t/p/w185/"
//
//        client.get(url, object : AsyncHttpResponseHandler(){
//            override fun onSuccess(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseBody: ByteArray?
//            ) {
//                try {
//                    val result = String(responseBody!!)
//                    val responseObject = JSONObject(result)
//                    val list = responseObject.getJSONArray("results")
//
//                    for(i in 0 until list.length()){
//                        val movie = list.getJSONObject(i)
//                        val movieItems = MovieItem()
//                        movieItems.id = movie.getInt("id")
//                        movieItems.name = movie.getString("title")
//                        movieItems.overview = movie.getString("overview")
//                        movieItems.date = movie.getString("release_date")
//                        movieItems.photo = posterPath + movie.getString("poster_path")
//                        Log.d("MovieViewModel", "msg"+movieItems.id)
//                        listItems.add(movieItems)
//                    }
//                    listMovies.postValue(listItems)
//                }catch (e: Exception){
//                    Log.d("Exception" , e.message.toString())
//                }
//
//            }
//
//            override fun onFailure(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseBody: ByteArray?,
//                error: Throwable?
//            ) {
//                Log.d("onFailure", error!!.message.toString())
//            }
//        })
//    }
//
//    internal fun getMovies() : LiveData<ArrayList<MovieItem>>{
//        return listMovies
//    }
}