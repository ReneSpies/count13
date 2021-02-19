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

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
	
	private val _shouldRenderBottomNavigationSheet = MutableLiveData<Boolean>()
	val shouldRenderBottomNavigationSheet: LiveData<Boolean>
		get() = _shouldRenderBottomNavigationSheet
	
	private val _shouldRenderAddCounterNoteDialogFragment = MutableLiveData<Boolean>()
	val shouldRenderAddCounterNoteDialogFragment: LiveData<Boolean>
		get() = _shouldRenderAddCounterNoteDialogFragment
	
	init {
		
		Timber.d("init: called")
		
		loadDefaultShouldRenderBottomNavigationSheetValue()
		loadDefaultShouldRenderAddCounterNoteDialogFragmentValue()
		
	}
	
	private fun loadDefaultShouldRenderBottomNavigationSheetValue() {
		
		Timber.d("loadDefaultShouldRenderBottomNavigationSheetValue: called")
		
		_shouldRenderBottomNavigationSheet.value = false
		
	}
	
	private fun loadDefaultShouldRenderAddCounterNoteDialogFragmentValue() {
		
		Timber.d("loadDefaultShouldRenderAddCounterNoteDialogFragmentValue: called")
		
		_shouldRenderAddCounterNoteDialogFragment.value = false
		
	}
	
	fun renderBottomNavigationSheet() {
		
		Timber.d("renderBottomNavigationSheet: called")
		
		_shouldRenderBottomNavigationSheet.value = true
		
	}
	
	fun renderAddCounterNoteDialogFragment() {
		
		Timber.d("renderAddCounterNoteDialogFragment: called")
		
		_shouldRenderAddCounterNoteDialogFragment.value = true
		
	}
	
}