package com.test.moviedb.core.usecases

import com.test.moviedb.core.data.MovieDBDetailRepository

class GetTvShowsDetailUseCase(private val repository: MovieDBDetailRepository) {
    suspend fun invoke(id: Int) = repository.getTvShowsDetail(id)
}