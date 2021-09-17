package com.test.moviedb.core.data


class MovieDBDetailRepository(private val dataSource: MovieDBDetailDataSource) {

    suspend fun getMovieDetail(id: Int) = dataSource.getMovieDetail(id)
    suspend fun getTvShowsDetail(id: Int) = dataSource.getTvShowsDetail(id)
}