package com.example.lab5

import android.app.Application
import com.example.lab5.data.model.movies
import com.example.lab5.repositories.MovieRepository

class MovieReviewerApplication : Application(){
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}