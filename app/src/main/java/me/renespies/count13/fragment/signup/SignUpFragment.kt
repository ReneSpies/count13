package me.renespies.count13.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.renespies.count13.databinding.FragmentSignUpBinding
import timber.log.Timber


/**
 *    Created on: 6 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding // Binding for the layout
    private lateinit var signUpViewModel: SignUpViewModel // Corresponding ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        Timber.d("onCreateView: called")

        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.viewModel = signUpViewModel

        return binding.root

    }

}