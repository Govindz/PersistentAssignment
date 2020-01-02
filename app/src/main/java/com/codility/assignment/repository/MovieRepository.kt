package com.info.assignment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.info.assignment.api.APIInterface
import com.info.assignment.api.ApiClient
import com.info.assignment.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* DataRepository class for API Request call to fetch data
* */
class MovieRepository {

    private var apiInterface: APIInterface? = null

    val model: MutableLiveData<MovieResponse>
        get() {
            val mutableLiveData = MutableLiveData<MovieResponse>()
            apiInterface = ApiClient.retrofitInstance.create(APIInterface::class.java)
            val call = apiInterface!!.data
            call.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.body() != null) {
                        mutableLiveData.value = response.body()
                        Log.e("Response : ", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                }
            })

            return mutableLiveData
        }
}
