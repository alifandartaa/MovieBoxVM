package com.example.movieboxvm.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieboxvm.R
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as MovieItem
        tv_detmov_value_name.text = movie.name
        tv_detmov_value_date.text = movie.date
        tv_detmov_value_overview.text = movie.overview
        Glide.with(applicationContext)
            .load(movie.photo)
            .apply(
                RequestOptions.placeholderOf(R.drawable.loading_img)
                    .error(R.drawable.ic_error_24dp))
            .into(img_detail_movie)
    }
}
