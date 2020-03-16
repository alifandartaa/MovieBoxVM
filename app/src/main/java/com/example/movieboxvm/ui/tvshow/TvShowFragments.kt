package com.example.movieboxvm.ui.tvshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieboxvm.R
import com.example.movieboxvm.ui.movie.MovieViewModel
import com.example.movieboxvm.ui.movie.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_tv_show_fragments.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragments : Fragment() {

    private lateinit var adapter : TvshowAdapter
    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show_fragments, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = TvshowAdapter()
        adapter.notifyDataSetChanged()

        rv_tvshows.layoutManager = LinearLayoutManager(context)
        rv_tvshows.adapter = adapter

        tvShowViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
        tvShowViewModel.setTvShow()
        showLoading(true)
        tvShowViewModel.getTvShows().observe(viewLifecycleOwner, Observer { TvshowItem ->
            if(TvshowItem != null){
                adapter.setTvshow(TvshowItem)
                showLoading(false)
            }
        })


    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pb_fragment_tvshow.visibility = View.VISIBLE
        } else {
            pb_fragment_tvshow.visibility = View.GONE
        }
    }

}
