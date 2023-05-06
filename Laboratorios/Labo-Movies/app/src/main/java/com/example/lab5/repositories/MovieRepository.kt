package com.example.lab5.repositories

import com.example.lab5.data.model.MovieModel
import com.example.lab5.data.movies

class MovieRepository(private val movies: MutableList<MovieModel>){
    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}