package me.renespies.count13.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber


/**
 *    Created on: 3 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _shouldRenderBottomNavigationSheet = MutableLiveData<Boolean>()
    val shouldRenderBottomNavigationSheet: LiveData<Boolean>
        get() = _shouldRenderBottomNavigationSheet

    init {

        Timber.d("init: called")

        loadDefaultShouldRenderBottomNavigationSheetValue()

    }

    private fun loadDefaultShouldRenderBottomNavigationSheetValue() {

        Timber.d("loadDefaultShouldRenderBottomNavigationSheetValue: called")

        _shouldRenderBottomNavigationSheet.value = false

    }

    fun renderBottomNavigationSheet() {

        Timber.d("renderBottomNavigationSheet: called")

        _shouldRenderBottomNavigationSheet.value = true

    }

}