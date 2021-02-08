package me.renespies.count13

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomappbar.BottomAppBar
import timber.log.Timber


/**
 *    Created on: 31 Jan 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


object Util {

    /**
     * BindingAdapter that shortcuts [BottomAppBar.setNavigationOnClickListener] by leveraging
     * DataBinding. It can be used by XML expressions just like app:onClick on a button.
     */
    @BindingAdapter("app:onNavigationItemSelected")
    @JvmStatic
    fun BottomAppBar.onNavigationItemSelected(
        block: () -> Unit
    ) {

        Timber.d("onNavigationItemSelected: called")

        setNavigationOnClickListener { block() }

    }

}