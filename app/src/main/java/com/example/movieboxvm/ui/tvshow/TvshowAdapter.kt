package com.example.movieboxvm.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieboxvm.R
import kotlinx.android.synthetic.main.item_tvshow.view.*

class TvshowAdapter : RecyclerView.Adapter<TvshowAdapter.TvshowViewHolder>() {
    private var listTvshow = ArrayList<TvshowItem>()

    fun setTvshow(tvshowItems: List<TvshowItem>?) {
        if (tvshowItems == null) return
        listTvshow.clear()
        listTvshow.addAll(tvshowItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tvshow, parent, false)
        return TvshowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = listTvshow[position]
        holder.bind(tvshow)
    }

    override fun getItemCount(): Int = listTvshow.size


    class TvshowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvshowItem: TvshowItem) {
            with(itemView) {
                tv_home_name_tvshow.text = tvshowItem.title
                tv_home_year_tvshow.text = tvshowItem.release
                setOnClickListener {
                    val intentDetailTvShow = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvshowItem)
                    }
                    context.startActivity(intentDetailTvShow)
                }
                Glide.with(context)
                    .load(tvshowItem.photo)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.loading_img)
                            .error(R.drawable.ic_error_24dp))
                    .into(img_home_tvshow)
            }
        }
    }
}