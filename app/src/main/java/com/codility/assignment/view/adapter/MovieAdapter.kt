package com.info.assignment.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.codility.assignment.R
import com.info.assignment.api.ApiClient
import com.info.assignment.model.Movie
import com.info.assignment.view.itemview.MovieItemView
import java.util.*

/*
* Adapter class for display list of movie rows in RecyclerView
* */
class MovieAdapter(private val movieList: ArrayList<Movie>) : RecyclerView.Adapter<MovieItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemView {
        return MovieItemView(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieItemView, position: Int) {
        val movie: Movie = movieList[position]
        //set title from data model
        holder.tvTitle?.text = movie.title
        // Set description from data model
        holder.tvDescription?.text = movie.overview
        // Load images from url
        Glide.with(holder.itemView.context)
            .load(ApiClient.IMAGE_BASE_URL.plus(movie.poster_path))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_error)
            .into(holder.imageView!!)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun notifyDataChanged(list: List<Movie>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }
}