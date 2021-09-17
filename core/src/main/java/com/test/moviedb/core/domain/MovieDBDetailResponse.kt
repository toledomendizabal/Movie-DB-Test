package com.test.moviedb.core.domain

import java.sql.Timestamp

data class MovieDBDetailResponse (
    val id:Int,
    val results:List<MovieDbItemDetail>?,
    val success: Boolean,
)

data class MovieDbItemDetail(
    val iso_639_1:String,
    val iso_3166_1:String,
    val name:String,
    val key:String,
    val site:String,
    val size:Int,
    val type:String,
    val official:Boolean,
    val published_at:Timestamp,
    val id:String
)