package com.example.movieboxvm.ui.tvshow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class TvShowViewModel : ViewModel(){
companion object{
    private const val API_KEY = "3148d91de7ab9fa0e608d7be83b7d967"
}

    val listTvShow = MutableLiveData<ArrayList<TvshowItem>>()
//
    fun setTvShow(){
        val client = AsyncHttpClient()
        val listItem  = ArrayList<TvshowItem>()
        val url = "https://api.themoviedb.org/3/discover/tv?api_key=${API_KEY}&language=en-US"
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
                        val tvshow = list.getJSONObject(i)
                        val tvShowItems = TvshowItem()
                        tvShowItems.id = tvshow.getInt("id")
                        tvShowItems.title = tvshow.getString("name")
                        tvShowItems.overview = tvshow.getString("overview")
                        tvShowItems.release = tvshow.getString("first_air_date")
                        tvShowItems.photo = posterPath + tvshow.getString("backdrop_path")
                        listItem.add(tvShowItems)
                    }
                    listTvShow.postValue(listItem)
                }catch (e: Exception){
                    Log.d("Exception", e.message.toString())
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
    }
//
    fun getTvShows() : LiveData<ArrayList<TvshowItem>> {
        return listTvShow
    }
}