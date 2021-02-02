package co.aresid.count13

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.android.material.bottomappbar.BottomAppBar
import timber.log.Timber


/**
 *    Created on: 31 Jan 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


object Util {

    @RequiresApi(Build.VERSION_CODES.M)
    fun BottomAppBar.test() {

        Timber.d("test: called")

        setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

            Timber.d("scroll listener")

        }

    }

}