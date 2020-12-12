package co.aresid.count13.fragment.counterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.aresid.count13.databinding.FragmentCounterListBinding
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

        // Return the inflated layout
        return binding.root

    }

}