package com.info.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.info.assignment.model.MovieResponse
import com.info.assignment.repository.MovieRepository

/* *
* ViewModel Class for attaching a model object to view
* */
class MovieViewModel : ViewModel() {
    // Implement the ViewModel
    var data: MutableLiveData<MovieResponse>? = null
        private set
    private val dataModel: MovieRepository = MovieRepository()

    fun init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so we know the Id won't change
            return
        }
        data = dataModel.model
    }
}