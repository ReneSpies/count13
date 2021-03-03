package me.renespies.count13.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.renespies.count13.database.counternotedata.CounterNoteData
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterNoteListAdapter(private var dataSet: List<CounterNoteData>): RecyclerView.Adapter<CounterNoteListViewHolder>() {
	
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
		
		holder.binding.counterNoteData = dataSet[position] // Pass the data to the binding
		
		holder.binding.viewHolder = holder // Pass a ViewHolder reference to the binding to use its functions
		
	}
	
	override fun getItemCount() = dataSet.size
	
	/**
	 * If the [CounterNoteListAdapter.dataSet] is null, updates it and notifies the RecyclerView about the changes.
	 * Otherwise, compares the new dataSet [dataSet] with the old dataSet [CounterNoteListAdapter.dataSet] and
	 * notifies the RecyclerView only about the changes that exist if any using [DiffUtil].
	 */
	fun setDataSet(newDataSet: List<CounterNoteData>) {
		
		Timber.d("setDataSet: called")
		
		// Check if the current dataSet is empty and replaces it with the new dataSet if so
		if (this.dataSet.isEmpty()) {
			
			this.dataSet = newDataSet
			notifyItemRangeInserted(
				0,
				newDataSet.size
			)
			
		}
		else {
			
			// Uses calculateDiff to check for any differences int he old, current dataSet and the new dataSet
			// Updates the RecyclerView accordingly using DiffUtil.Result.dispatchUpdatesTo
			val differenceResult = DiffUtil.calculateDiff(object: DiffUtil.Callback() {
				
				override fun getOldListSize() = dataSet.size
				
				override fun getNewListSize() = newDataSet.size
				
				override fun areItemsTheSame(
					oldItemPosition: Int,
					newItemPosition: Int
				): Boolean {
					
					return dataSet[oldItemPosition].id == newDataSet[newItemPosition].id
					
				}
				
				override fun areContentsTheSame(
					oldItemPosition: Int,
					newItemPosition: Int
				): Boolean {
					
					val counterNoteData = dataSet[oldItemPosition]
					val newCounterNoteData = newDataSet[newItemPosition]
					
					return counterNoteData == newCounterNoteData
					
				}
				
			})
			
			dataSet = newDataSet // Update the old, current dataSet to be the new dataSet
			differenceResult.dispatchUpdatesTo(this) // Update the RecyclerView
			
		}
		
	}
	
}