package me.renespies.count13.fragment.bottomnavigationsheet

import android.app.Application
import android.view.MenuItem
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.renespies.count13.R
import me.renespies.count13.Util
import timber.log.Timber


/**
 *    Created on: 3 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


class BottomNavigationSheetViewModel(application: Application) : AndroidViewModel(application) {

    private val _navigateTo = MutableLiveData<Util.Navigate>()
    val navigateTo: LiveData<Util.Navigate>
        get() = _navigateTo

    init {

        Timber.d("init: called")

        loadDefaultNavigateToValue() // Initialize LiveData

    }

    /**
     * Initializes the [_navigateTo] LiveData with its default
     * value [Util.Navigate.DEFAULT].
     */
    private fun loadDefaultNavigateToValue() {

        Timber.d("loadDefaultNavigateToValue: called")

        _navigateTo.value = Util.Navigate.DEFAULT

    }

    /**
     * Evaluates the [menuItem] parameter and sets the [_navigateTo]
     * LiveData accordingly.
     */
    fun onMenuItemSelected(menuItem: MenuItem) {

        Timber.d("onMenuItemSelected: called")

        when (menuItem.itemId) {

            R.id.home -> _navigateTo.value = Util.Navigate.TO_HOME // Navigate to the CounterListFragment

            R.id.sign_up -> _navigateTo.value = Util.Navigate.TO_SIGN_UP // Navigate to the SignUpFragment

            R.id.settings -> _navigateTo.value = Util.Navigate.TO_SETTINGS // Navigate to the SettingsFragment

        }

    }

}