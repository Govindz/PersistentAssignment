package com.info.assignment.model

import com.google.gson.annotations.SerializedName

/*
* Get API Object of list
* */
class MovieResponse {

    @SerializedName("results")
    lateinit var rows: List<Movie>

}