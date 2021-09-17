package com.test.moviedb.datasource

import com.test.moviedb.core.data.MovieDBDetailDataSource
import com.test.moviedb.core.domain.MovieDbItemDetail
import com.test.moviedb.core.domain.Response
import com.test.moviedb.network.Api

class MovieDBDetailNetworkDataSource(private val api: Api) : MovieDBDetailDataSource {

    override suspend fun getMovieDetail(id: Int): Response<MovieDbItemDetail> {
        return try {
            val response = api.getMovieDetail(id, "movie").results
            if (response != null && response.isNotEmpty()) Response.Success(response[0])
            else Response.Error("")
        } catch (e: Exception) {
            Response.Error(e.message ?: "")
        }
    }

    override suspend fun getTvShowsDetail(id: Int): Response<MovieDbItemDetail> {
        return try {
            val response = api.getMovieDetail(id, "tv").results
            if (response != null && response.isNotEmpty()) Response.Success(response[0])
            else Response.Error("")
        } catch (e: Exception) {
            Response.Error(e.message ?: "")
        }
    }
}