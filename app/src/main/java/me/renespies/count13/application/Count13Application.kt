package me.renespies.count13.application

import android.app.Application
import timber.log.Timber


/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */


class Count13Application : Application() {

    /*
    ONLY EDIT IF NECESSARY!
     */

    override fun onCreate() {
        super.onCreate()

        // Initialize Timber
        Timber.plant(Timber.DebugTree())

    }

}