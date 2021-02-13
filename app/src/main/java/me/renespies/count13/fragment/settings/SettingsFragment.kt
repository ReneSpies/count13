package me.renespies.count13.fragment.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.renespies.count13.databinding.FragmentSettingsBinding
import timber.log.Timber

/**
 *    Created on: 6 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding // Binding for the layout
    private lateinit var settingsViewModel: SettingsViewModel // Corresponding ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Timber.d("onCreateView: called")

        binding = FragmentSettingsBinding.inflate(
            inflater,
            container,
            false
        )

        settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        binding.viewModel = settingsViewModel

        return binding.root

    }
}