package me.renespies.count13.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.renespies.count13.database.counternotedata.CounterNoteData
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterNoteListAdapter(private val dataSet: List<CounterNoteData>): RecyclerView.Adapter<CounterNoteListViewHolder>() {
	
	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): CounterNoteListViewHolder {
		
		Timber.d("onCreateViewHolder: called")
		
		return CounterNoteListViewHolder.from(parent)
		
	}
	
	override fun onBindViewHolder(
		holder: CounterNoteListViewHolder,
		position: Int
	) {
		
		Timber.d("onBindViewHolder: called")
		
		holder.binding.counterNote = dataSet[position]
		
	}
	
	override fun getItemCount() = dataSet.size
	
}