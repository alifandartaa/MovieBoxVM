package com.example.movieboxvm.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieboxvm.R
import com.example.movieboxvm.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

//    private lateinit var adapter: MoviesAdapter
//    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
//            val movies = viewModel.getMovies()

            val movieAdapter = MoviesAdapter()
            showLoading(true)
            viewModel.getMovies().observe(viewLifecycleOwner, Observer { movies ->
                showLoading(false)
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })
//            adapter.setMovies(movies)
//            adapter.notifyDataSetChanged()
            with(rv_movies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

//            movieViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
//            movieViewModel.setMovies()

//            showLoading(true)
//            movieViewModel.getMovies().observe(viewLifecycleOwner, Observer { MovieItem ->
//                if(MovieItem != null){
//                    adapter.setMovies(MovieItem)
//                    showLoading(false)
//                }
//            })


        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pb_fragment_movie.visibility = View.VISIBLE
        } else {
            pb_fragment_movie.visibility = View.GONE
        }
    }

}
