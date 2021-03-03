package me.renespies.count13.recyclerview

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.renespies.count13.database.counternotedata.CounterNoteData
import me.renespies.count13.database.repository.Count13Repository
import me.renespies.count13.databinding.ItemCounterListBinding
import org.jetbrains.annotations.NotNull
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterNoteListViewHolder private constructor(
	@NotNull val binding: ItemCounterListBinding,
	@NotNull val context: Context
): RecyclerView.ViewHolder(binding.root) {
	
	// IO CoroutineScope used to update any rows in the database
	// Initialized by lazy because not every RecyclerView item needs to update the database
	private val ioScope: CoroutineScope by lazy {
		
		CoroutineScope(Dispatchers.IO)
		
	}
	
	// The Count13Repository used to update the database
	// Initialized by lazy because not every RecyclerView item needs to update the database
	private val repository by lazy {
		
		Count13Repository.getInstance(context.applicationContext as Application)
		
	}
	
	/**
	 * Function launches a CoroutineScope in the IO context and uses the [repository] to update the database.
	 */
	private fun updateCounterNoteData(data: CounterNoteData) {
		
		Timber.d("updateCounterNoteData: called")
		
		ioScope.launch {
			
			try {
				
				repository.updateCounterNote(data) // Update the database
				
			}
			catch (exception: Exception) {
				
				Timber.e(exception)
				
			}
			
		}
		
	}
	
	/**
	 * Makes a copy of the current CounterNoteData, increments its count and updates the database.
	 *
	 * @see decrementCount
	 */
	fun incrementCount() {
		
		Timber.d("incrementCount: called")
		
		binding.counterNoteData?.let { counterNoteData ->
			
			val temporaryCounterNoteData = counterNoteData.copy(count = counterNoteData.count + 1) // Make a copy and only update the count
			
			updateCounterNoteData(temporaryCounterNoteData) // Update the database
			
		}
		
	}
	
	/**
	 * Makes a copy of the current CounterNoteData, decrements its count and updates the database.
	 *
	 * @see incrementCount
	 */
	fun decrementCount() {
		
		Timber.d("decrementCount: called")
		
		binding.counterNoteData?.let { counterNoteData ->
			
			val temporaryCounterNoteData = counterNoteData.copy(count = counterNoteData.count - 1) // Make a copy and only update the count
			
			updateCounterNoteData(temporaryCounterNoteData) // Update the database
			
		}
		
	}
	
	companion object {
		
		fun from(parent: ViewGroup): CounterNoteListViewHolder {
			
			Timber.d("from: called")
			
			val context = parent.context
			val layoutInflater = LayoutInflater.from(context)
			val binding = ItemCounterListBinding.inflate(
				layoutInflater,
				parent,
				false
			)
			
			return CounterNoteListViewHolder(
				binding,
				context
			)
			
		}
		
	}
	
}