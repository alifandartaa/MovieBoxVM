package com.example.movieboxvm.ui.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieboxvm.R
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val tvshow = intent.getParcelableExtra(EXTRA_TVSHOW) as TvshowItem
        tv_detshow_value_name.text = tvshow.title
        tv_detshow_value_date.text = tvshow.release
        tv_detshow_value_overview.text = tvshow.overview
        Glide.with(applicationContext)
            .load(tvshow.photo)
            .apply(
                RequestOptions.placeholderOf(R.drawable.loading_img)
                    .error(R.drawable.ic_error_24dp))
            .into(img_detail_tvshow)


    }
}
