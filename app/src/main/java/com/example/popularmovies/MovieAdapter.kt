package com.example.popularmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popularmovies.model.Movie

class MovieAdapter(private val clickListener: MovieClickListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movies= mutableListOf<Movie>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_movie_item, parent, false)
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            clickListener.onMovieClick(movie) }
    }

    override fun getItemCount() = movies.size

    fun addMovies(movieList: List<Movie>){
    movies.addAll(movieList)
    notifyItemRangeInserted(0,movieList.size)
    }
    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageUrl= "https://image.tmdb.org/t/p/w185"

        private val titleText: TextView by lazy {
            itemView.findViewById(R.id.movie_poster)
        }
        private val poster: ImageView by lazy {
            itemView.findViewById(R.id.movie_poster)
        }
        fun bind(movie: Movie){
            titleText.text=movie.title

            Glide.with(itemView.context)
                .load("$imageUrl${movie.poster_path}")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(poster)


        }
    }
    interface MovieClickListener{
        fun onMovieClick(movie: Movie)
    }

}
