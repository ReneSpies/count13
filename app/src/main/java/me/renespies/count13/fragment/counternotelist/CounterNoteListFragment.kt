package me.renespies.count13.fragment.counternotelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.renespies.count13.databinding.FragmentCounterNoteListBinding
import me.renespies.count13.recyclerview.CounterNoteListAdapter
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterNoteListFragment : Fragment() {

    // Binding for the layout
    private lateinit var binding: FragmentCounterNoteListBinding

    // Corresponding ViewModel
    private lateinit var counterNoteListViewModel: CounterNoteListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Timber.d("onCreateView: called")

        // Define the binding and inflate the layout
        binding = FragmentCounterNoteListBinding.inflate(
            inflater,
            container,
            false
        )

        // Define the ViewModel
        counterNoteListViewModel = ViewModelProvider(this).get(CounterNoteListViewModel::class.java)

        counterNoteListViewModel.allCounterNotes.observe(viewLifecycleOwner) {
	
	        it?.let {
		
                (binding.counterNoteListRecyclerView.adapter as CounterNoteListAdapter).setDataSet(it) // Update the adapter with the new data
		
	        }
	
        }
    
        constructRecyclerView()

        // Return the inflated layout
        return binding.root

    }

    private fun constructRecyclerView() {

        Timber.d("constructRecyclerView: called")

        // Create the adapter
	    val counterNoteListAdapter = CounterNoteListAdapter(listOf())

        // Give the RecyclerView the LayoutManger, the adapter and a fixed size
        binding.counterNoteListRecyclerView.apply {

            // I know that my items do not change in their size
            // so I can set fixedSize to true for better performance
            setHasFixedSize(true)

            // Apply the adapter
            adapter = counterNoteListAdapter

        }

    }

}