package com.example.movieboxvm.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieboxvm.R
import com.example.movieboxvm.data.source.entity.MovieEntity
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movieItems: List<MovieEntity>?) {
        if (movieItems == null) return
        listMovies.clear()
        listMovies.addAll(movieItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieItem: MovieEntity) {
            with(itemView) {
                tv_home_name_movie.text = movieItem.title
                tv_home_date_movie.text = movieItem.release
                setOnClickListener {
//                    val intentDetailMovie = Intent(context, DetailMovieActivity::class.java).apply {
//                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movieItem)
//                    }
//                    context.startActivity(intentDetailMovie)
                }
                Glide.with(context)
                    .load(movieItem.photo)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.loading_img)
                        .error(R.drawable.ic_error_24dp))
                    .into(img_home_movie)
            }
        }
    }
}