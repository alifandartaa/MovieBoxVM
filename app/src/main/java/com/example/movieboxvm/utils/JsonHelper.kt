package com.example.movieboxvm.utils

import android.content.Context
import android.util.Log
import com.example.movieboxvm.data.source.remote.response.MovieItemResponse
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONException
import org.json.JSONObject

class JsonHelper(private val context: Context) {

    companion object{
        private const val API_KEY = "3148d91de7ab9fa0e608d7be83b7d967"
    }

    fun loadMovies(): List<MovieItemResponse>{
//        val list = ArrayList<MovieItemResponse>()
        val client = AsyncHttpClient()
        val listItem  = ArrayList<MovieItemResponse>()
        val url = "https://api.themoviedb.org/3/discover/movie?api_key=${API_KEY}&language=en-US"
        val posterPath = "https://image.tmdb.org/t/p/w185/"

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                try {
                    val result = String(responseBody!!)
                    val responseObject = JSONObject(result)
                    val list = responseObject.getJSONArray("results")

                    for (i in 0 until list.length()){
                        val movie = list.getJSONObject(i)

                        val id = movie.getInt("id")
                        val name = movie.getString("title")
                        val overview = movie.getString("overview")
                        val date = movie.getString("release_date")
                        val photo = posterPath + movie.getString("poster_path")
                        val movieItemResponse = MovieItemResponse(id, name, overview, date,
                            photo)
                        listItem.add(movieItemResponse)
                    }
//                    listTvShow.postValue(listItem)
                }catch (e: JSONException){
                    e.printStackTrace()
                }


            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                if (error != null) {
                    Log.d("onFailure", error.message.toString())
                }
            }
        })
        return listItem
    }
}