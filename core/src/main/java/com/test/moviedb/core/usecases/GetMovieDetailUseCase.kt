package com.test.moviedb.core.usecases

import com.test.moviedb.core.data.MovieDBDetailRepository

class GetMovieDetailUseCase(private val repository: MovieDBDetailRepository) {
    suspend fun invoke(id: Int) = repository.getMovieDetail(id)
}