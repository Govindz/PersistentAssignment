package com.codility.assignment.view.ui

import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codility.assignment.R
import com.google.android.material.snackbar.Snackbar
import com.info.assignment.model.Movie
import com.info.assignment.utils.Utility
import com.info.assignment.view.adapter.MovieAdapter
import com.info.assignment.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private var mViewModel: MovieViewModel? = null
    private var movieList = ArrayList<Movie>()
    private var movieAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        /*
         * Set List of rows in adapter
         * */
        movieAdapter = MovieAdapter(movieList)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = movieAdapter

        loadMovieList()
    }

    private fun loadMovieList() {
        if (Utility.isOnline(this)) {
            mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
            mViewModel!!.init()
            mViewModel!!.data!!.observe(this, androidx.lifecycle.Observer {

                //Set title in toolbar
                this.title = getString(R.string.top_rated_movies)

                //set list in RecyclerView from response i.e 'rows'
                movieAdapter?.notifyDataChanged(it.rows)
                progressBar?.visibility = View.GONE

            })
        } else {
            Utility.showToast(this, getString(R.string.no_internet))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Utility.showToast(this, getString(R.string.click_twice_to_exit))

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
