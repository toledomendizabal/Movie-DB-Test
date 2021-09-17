package com.test.moviedb.core.interactors

import com.test.moviedb.core.usecases.GetNowPlayingMoviesUseCase
import com.test.moviedb.core.usecases.GetPopularMoviesUseCase
import com.test.moviedb.core.usecases.GetPopularTvShowsUseCase
import com.test.moviedb.core.usecases.GetTopRatedTvShowsUseCase

data class MovieDBInteractors(
    val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    val getPopularTvShowsUseCase: GetPopularTvShowsUseCase,
    val getTopRatedTvShowsUseCase: GetTopRatedTvShowsUseCase,
)