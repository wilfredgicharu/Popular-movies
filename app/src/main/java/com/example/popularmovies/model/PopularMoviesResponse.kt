package com.example.popularmovies.model

import io.reactivex.rxjava3.core.Scheduler

class PopularMoviesResponse(
    val page: Int,
    val results: List<Movie>
)