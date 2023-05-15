package com.example.lab5.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.R
import com.example.lab5.data.model.MovieModel
import com.example.lab5.databinding.FragmentMovieListBinding
import com.example.lab5.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.lab5.ui.movie.viewmodel.MovieViewModel

/* *

billboardFragment

* */
class MovieList : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var adapter: MovieRecyclerViewAdapter
    private lateinit var binding: FragmentMovieListBinding

    /*private lateinit var newMovieButtonFragment: Button
    private lateinit var movieDetailClickFragment: TextView*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movie_list, container, false)
        binding= FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*bind()
        newMovieButtonFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_movieList_to_movie_new)
        }

        movieDetailClickFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_movieList_to_movieDetails)
        }*/
        setRecyclerView(view)
        binding.newmovieButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_movieList_to_movie_new)
        }

    }

    /*private fun bind(){
        newMovieButtonFragment = view?.findViewById(R.id.newmovieButton) as Button
        movieDetailClickFragment = view?.findViewById(R.id.movieTitle1) as TextView
    }*/

    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_movieList_to_movieDetails)
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selectedMovie -> showSelectedItem(selectedMovie) }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }
}