package me.renespies.count13.fragment.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import timber.log.Timber

/**
 *    Created on: 6 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    init {

        Timber.d("init: called")

    }

}