package me.renespies.count13.fragment.counterlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import timber.log.Timber


/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */


class CounterListViewModel(application: Application) : AndroidViewModel(application) {

    init {

        Timber.d("init: called")

    }

}