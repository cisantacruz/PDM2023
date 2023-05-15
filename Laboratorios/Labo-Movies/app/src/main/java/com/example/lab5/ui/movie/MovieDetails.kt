package com.example.lab5.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lab5.databinding.FragmentMovieDetailsBinding
import com.example.lab5.ui.movie.viewmodel.MovieViewModel

class MovieDetails : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_movie_details, container, false)
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel=movieViewModel
    }
}