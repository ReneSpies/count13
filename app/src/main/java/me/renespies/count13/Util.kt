package me.renespies.count13

import android.view.MenuItem
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView
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

    /**
     * BindingAdapter that shortcuts [NavigationView.setNavigationItemSelectedListener] by leveraging
     * DataBinding. It can be used by XML expressions just like app:onClick on a button.
     */
    @BindingAdapter("app:onMenuItemSelected")
    @JvmStatic
    fun NavigationView.onMenuItemSelected(
        block: MenuItemSelected
    ) {

        Timber.d("onMenuItemSelected: called")

        setNavigationItemSelectedListener { block.onMenuItemSelected(it); false }

    }

    /**
     * Short interface to use with [NavigationView.onMenuItemSelected] for
     * XML lambdas with parameters.
     */
    interface MenuItemSelected {

        fun onMenuItemSelected(menuItem: MenuItem)

    }

    enum class Navigate {

        /**
         * The default value to initialize any LiveData.
         */
        DEFAULT,

        /**
         * Value to signal the navigation to the CounterListFragment.
         */
        TO_HOME,

        /**
         * Value to signal the navigation to the SignUpFragment.
         */
        TO_SIGN_UP,

        /**
         * Value to signal the navigation to the SettingsFragment.
         */
        TO_SETTINGS

    }

}