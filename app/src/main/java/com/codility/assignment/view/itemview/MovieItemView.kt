package com.info.assignment.view.itemview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codility.assignment.R

/* *
 *ViewHolder items for MovieAdapter
 * */
class MovieItemView(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    val tvTitle = itemView?.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = itemView?.findViewById<TextView>(R.id.tvDescription)
    val imageView = itemView?.findViewById<ImageView>(R.id.imageView)
}