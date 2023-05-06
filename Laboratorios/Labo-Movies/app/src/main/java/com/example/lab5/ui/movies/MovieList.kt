package com.example.lab5.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab5.R

class MovieList : Fragment() {
    private lateinit var newMovieButtonFragment: Button
    private lateinit var movieDetailClickFragment: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        newMovieButtonFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_movieList_to_movie_new)
        }

        movieDetailClickFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_movieList_to_movieDetails)
        }

    }

    private fun bind(){
        newMovieButtonFragment = view?.findViewById(R.id.newmovieButton) as Button
        movieDetailClickFragment = view?.findViewById(R.id.movieTitle1) as TextView
    }
}