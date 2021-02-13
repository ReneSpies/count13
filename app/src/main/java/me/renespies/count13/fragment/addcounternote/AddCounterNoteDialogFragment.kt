package me.renespies.count13.fragment.addcounternote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import me.renespies.count13.R
import me.renespies.count13.Util
import me.renespies.count13.Util.resetAllTextInputLayoutErrors
import me.renespies.count13.databinding.DialogFragmentAddCounterNoteBinding
import timber.log.Timber

/**
 *    Created on: 13 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

class AddCounterNoteDialogFragment: DialogFragment() {
	
	private lateinit var binding: DialogFragmentAddCounterNoteBinding // Binding for the layout
	private lateinit var addCounterNoteDialogViewModel: AddCounterNoteDialogViewModel // Corresponding ViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		
		Timber.d("onCreateView: called")
		
		// Define the binding and inflate the layout
		binding = DialogFragmentAddCounterNoteBinding.inflate(
			inflater,
			container,
			false
		)
		
		// Define the ViewModel
		addCounterNoteDialogViewModel = ViewModelProvider(this).get(AddCounterNoteDialogViewModel::class.java)
		binding.viewModel = addCounterNoteDialogViewModel
		
		addCounterNoteDialogViewModel.addNoteFormErrorType.observe(this) {
			
			renderAddNoteFormError(it)
			
		}
		
		return binding.root // Return the inflated layout
		
	}
	
	/**
	 * Evaluates the [errorType] and renders the appropriate error message or resets all existing errors.
	 */
	private fun renderAddNoteFormError(errorType: Util.AddNoteFormErrorType) {
		
		Timber.d("renderAddNoteFormError: called")
		
		when (errorType) {
			
			Util.AddNoteFormErrorType.DEFAULT -> {
				
				binding.constraintLayout.resetAllTextInputLayoutErrors() // Reset all error messages
				
			}
			
			Util.AddNoteFormErrorType.MISSING_TITLE -> binding.addNoteTitleLayout.error = getString(R.string.title_missing) // Render an error message
			
		}
		
	}
	
	override fun getTheme(): Int {
		
		Timber.d("getTheme: called")
		
		return android.R.style.Theme_Material_Dialog_NoActionBar_MinWidth
		
	}
	
}