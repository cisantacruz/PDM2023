package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.MovieWithActor

@Dao
interface MovieDao {
    @Query("SELECT * FROM MOVIE_TABLE")
    suspend fun getAllMovies(): List<MovieModel>

    @Insert
    suspend fun insertMovie(Movie: MovieModel)

    @Query("SELECT * FROM MOVIE_TABLE WHERE MovieId = :id")
    suspend fun getMovieWithActorById(id: Int): MovieWithActor?
}