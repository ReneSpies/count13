package co.aresid.count13.fragment.counterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.aresid.count13.databinding.FragmentCounterListBinding
import co.aresid.count13.recyclerview.CounterListAdapter
import timber.log.Timber


/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */


class CounterListFragment : Fragment() {

    // Binding for the layout
    private lateinit var binding: FragmentCounterListBinding

    // Corresponding ViewModel
    private lateinit var counterListViewModel: CounterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Timber.d("onCreateView: called")

        // Define the binding and inflate the layout
        binding = FragmentCounterListBinding.inflate(inflater, container, false)

        // Define the ViewModel
        counterListViewModel = ViewModelProvider(this).get(CounterListViewModel::class.java)

        constructRecyclerView()

        // Return the inflated layout
        return binding.root

    }

    private fun constructRecyclerView() {

        Timber.d("constructRecyclerView: called")

        // Create a linear LayoutManager
        val linearLayoutManager = LinearLayoutManager(context)

        // Create the adapter
        val counterListAdapter = CounterListAdapter()

        // Give the RecyclerView the LayoutManger, the adapter and a fixed size
        binding.counterListRecyclerView.apply {

            // I know that my items do not change in their size
            // so I can set fixedSize to true for better performance
            setHasFixedSize(true)

            // Apply the LayoutManager
            layoutManager = linearLayoutManager

            // Apply the adapter
            adapter = counterListAdapter

        }

    }

}