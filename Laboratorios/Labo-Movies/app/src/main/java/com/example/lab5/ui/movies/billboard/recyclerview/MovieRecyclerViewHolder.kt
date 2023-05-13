package com.example.lab5.ui.movies.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.data.model.MovieModel
import com.example.lab5.databinding.MovieItemBinding


class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.movieTitle1.text = movie.name
        binding.movieCalification1.text = movie.calification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}