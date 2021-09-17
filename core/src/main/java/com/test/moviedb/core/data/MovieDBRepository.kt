package com.test.moviedb.core.data

class MovieDBRepository(private val dataSource: MovieDBDataSource) {
    suspend fun getPopularMovies() = dataSource.getPopularMovies()
    suspend fun getPopularTvShows() = dataSource.getPopularTvShows()
    suspend fun getNowPlayingMovies() = dataSource.getNowPlayingMovies()
    suspend fun getTopRatedTvShows() = dataSource.getTopRatedTvShows()
}