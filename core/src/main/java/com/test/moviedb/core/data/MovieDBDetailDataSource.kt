package com.test.moviedb.core.data

import com.test.moviedb.core.domain.MovieDbItemDetail
import com.test.moviedb.core.domain.Response

interface MovieDBDetailDataSource {
    suspend fun getMovieDetail(id: Int): Response<MovieDbItemDetail>
    suspend fun getTvShowsDetail(id: Int): Response<MovieDbItemDetail>
}