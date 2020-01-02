@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATION",
    "NAME_SHADOWING"
)

package com.info.assignment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

object Utility {

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo.isConnectedOrConnecting
    }

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}