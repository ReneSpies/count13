package me.renespies.count13.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.renespies.count13.databinding.ItemCounterListBinding
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterNoteListViewHolder private constructor(val binding: ItemCounterListBinding): RecyclerView.ViewHolder(binding.root) {
	
	companion object {
		
		fun from(parent: ViewGroup): CounterNoteListViewHolder {
			
			Timber.d("from: called")
			
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = ItemCounterListBinding.inflate(
				layoutInflater,
				parent,
				false
			)
			
			return CounterNoteListViewHolder(binding)
			
		}
		
	}
	
}