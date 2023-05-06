package com.example.lab5.data

import com.example.lab5.data.model.MovieModel

val name = "Movie 1"
val category = "Category 1"
val description = "movie description"
val calification = "8.5"

var movies = mutableListOf(
    MovieModel(name, category, description, calification)
)