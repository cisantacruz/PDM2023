package com.example.lab5.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lab5.R
import com.example.lab5.data.model.MovieModel
import com.example.lab5.databinding.FragmentMovieNewBinding

class Movie_new : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var calificationEditText: EditText
    private lateinit var submitButton: Button

    private lateinit var binding: FragmentMovieNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movie_new, container, false)
        binding= FragmentMovieNewBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setViewModel(){
        binding.viewmodel=movieViewModel
    }

    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*bind()
        submitButton.setOnClickListener{
            addMovie()
        }*/
        setViewModel()
        observeStatus()
    }

    /*fun bind(){
        nameEditText = view?.findViewById(R.id.nameFieldData) !!
        categoryEditText = view?.findViewById(R.id.categoryFieldData) !!
        descriptionEditText = view?.findViewById(R.id.descriptionFieldData) !!
        calificationEditText = view?.findViewById(R.id.calificationFieldData) !!
        submitButton = view?.findViewById(R.id.newmovieButton) !!
    }*/

    private fun addMovie(){
        val name = nameEditText.text.toString()
        val category = categoryEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val calification = calificationEditText.text.toString()

        val movie = MovieModel(name, category, description, calification)

        movieViewModel.addMovies(movie)

        findNavController().popBackStack()
    }

    companion object{
        const val APP_TAG = "APP TAG"
    }
}