package me.renespies.count13.fragment.addcounternote

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch
import me.renespies.count13.Util.AddNoteFormErrorType
import me.renespies.count13.Util.disableButtonAndRenderLoadingSpinner
import me.renespies.count13.Util.enableButtonAndShowCheckSignFor500Milliseconds
import me.renespies.count13.database.counternotedata.CounterNoteData
import me.renespies.count13.database.repository.Count13Repository
import timber.log.Timber
import java.util.*

/**
 *    Created on: 13 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

class AddCounterNoteDialogViewModel(application: Application): AndroidViewModel(application) {
	
	var noteTitle = ""
	var noteDescription = ""
	var noteStartCount = "0"
	
	private val _addNoteFormErrorType = MutableLiveData<AddNoteFormErrorType>()
	val addNoteFormErrorType: LiveData<AddNoteFormErrorType>
		get() = _addNoteFormErrorType
	
	init {
		
		Timber.d("init: called")
		
		_addNoteFormErrorType.value = AddNoteFormErrorType.DEFAULT
		
	}
	
	/**
	 * Checks if the given information is correct and if so, inserts a new [CounterNoteData] instance into the database.
	 */
	fun addNote(view: View) {
		
		Timber.d("addNote: called")
		
		_addNoteFormErrorType.value = AddNoteFormErrorType.DEFAULT // Reset all existing errors
		
		val button = view as MaterialButton // Cast the passed in view as MaterialButton
		
		// Render an appropriate error message when the title field is blank
		if (noteTitle.isEmpty()) {
			
			_addNoteFormErrorType.value = AddNoteFormErrorType.MISSING_TITLE
			
			return
			
		}
		
		// Use a 0 as the default count if the user left the field blank
		if (noteStartCount.isEmpty()) {
			
			noteStartCount = "0"
			
		}
		
		
		viewModelScope.launch {
			
			try {
				
				button.disableButtonAndRenderLoadingSpinner() // Disable the button and show a loading animation
				
				val now = Calendar.getInstance().timeInMillis // Get the current time in milliseconds
				
				// Create a new CounterNoteData instance from the given information
				val counterNoteData = CounterNoteData(
					
					id = 0, // Will be set automatically
					title = noteTitle,
					description = noteDescription,
					count = noteStartCount.toInt(),
					creationDate = now
				
				)
				
				val repository = Count13Repository.getInstance(getApplication()) // Get a Count13Repository instance
				
				repository.insertCounterNote(counterNoteData) // Insert the new CounterNoteData instance into the database
				
				button.enableButtonAndShowCheckSignFor500Milliseconds() // Re-enable the button and show a check sign indicating that the operation succeeded
				
			}
			catch (exception: Exception) {
				
				Timber.e(exception)
				
				TODO("Render an error Snackbar")
				
			}
			
		}
		
	}
	
}