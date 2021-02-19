package me.renespies.count13.fragment.counternotelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import me.renespies.count13.database.counternotedata.CounterNoteData
import me.renespies.count13.database.repository.Count13Repository
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterNoteListViewModel(application: Application): AndroidViewModel(application) {
	
	val allCounterNotes: LiveData<List<CounterNoteData>>
		get() {
			
			val repository = Count13Repository.getInstance(getApplication())
			
			return repository.getAllCounterNotesLiveData()
			
		}
	
	init {
		
		Timber.d("init: called")
		
	}
	
}