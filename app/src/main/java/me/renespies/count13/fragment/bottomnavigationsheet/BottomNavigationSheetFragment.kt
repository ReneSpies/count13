package me.renespies.count13.fragment.bottomnavigationsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import me.renespies.count13.databinding.FragmentBottomNavigationSheetBinding
import timber.log.Timber


/**
 *    Created on: 3 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


class BottomNavigationSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomNavigationSheetBinding // Binding for the layout
    private lateinit var bottomNavigationSheetViewModel: BottomNavigationSheetViewModel // Corresponding ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.d("onCreateView: called")

        binding = FragmentBottomNavigationSheetBinding.inflate(inflater, container, false)

        bottomNavigationSheetViewModel = ViewModelProvider(this).get(BottomNavigationSheetViewModel::class.java)
        binding.viewModel = bottomNavigationSheetViewModel

        return binding.root
    }

}