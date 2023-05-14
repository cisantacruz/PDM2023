package com.example.lab5.repositories

import com.example.lab5.data.model.MovieModel
//import com.example.lab5.data.movies

class MovieRepository(private val Movies: MutableList<MovieModel>){
    fun getMovies() = Movies

    fun addMovies(Movie: MovieModel) = Movies.add(Movie)
}