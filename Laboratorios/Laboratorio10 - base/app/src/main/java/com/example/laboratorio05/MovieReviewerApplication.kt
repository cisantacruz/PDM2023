package com.example.laboratorio05

import android.app.Application
import com.example.laboratorio05.data.MovieReviewerDatabase
import com.example.laboratorio05.repositories.ActorRepository
import com.example.laboratorio05.repositories.CastRepository
import com.example.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    private val Database: MovieReviewerDatabase by lazy {
        MovieReviewerDatabase.newInstance(this)
    }

    val movieRepository: MovieRepository by lazy {
        MovieRepository(Database.movieDao())
    }
    val actorRepository: ActorRepository by lazy {
        ActorRepository(Database.actorDao())
    }
    val castRepository: CastRepository by lazy {
        CastRepository(Database.castDao())
    }
}