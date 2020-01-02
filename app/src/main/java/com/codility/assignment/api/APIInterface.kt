package com.info.assignment.api

import com.info.assignment.model.MovieResponse

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @get:GET("movie/top_rated?api_key=e93f47884ef4159c0e81f6b473375f70")
    val data: Call<MovieResponse>
}