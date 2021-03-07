package me.renespies.count13.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import me.renespies.count13.databinding.ActivityMainBinding
import me.renespies.count13.fragment.addcounternote.AddCounterNoteDialogFragment
import me.renespies.count13.fragment.bottomnavigationsheet.BottomNavigationSheetFragment
import timber.log.Timber

class MainActivity: AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding // Binding for the layout
	private lateinit var mainActivityViewModel: MainActivityViewModel // Corresponding ViewModel
	
	override fun onCreate(savedInstanceState: Bundle?) {
		
		Timber.d("onCreate: called")
		
		super.onCreate(savedInstanceState)
		
		// Define the binding and inflate the layout
		binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
		
		mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
		binding.viewModel = mainActivityViewModel
		
		mainActivityViewModel.shouldRenderBottomNavigationSheet.observe(this) {
				
				shouldShow ->
			
			if (shouldShow) renderBottomNavigationSheet()
			
		}
		
		mainActivityViewModel.shouldRenderAddCounterNoteDialogFragment.observe(this) {
				
				shouldShow ->
			
			if (shouldShow) renderAddCounterNoteDialogFragment()
			
		}
		
		setContentView(binding.root) // Render the inflated layout
		
	}
	
	/**
	 * Renders an instance of [BottomNavigationSheetFragment] and then
	 * resets the [MainActivityViewModel.shouldRenderBottomNavigationSheet] LiveData value.
	 */
	private fun renderBottomNavigationSheet() {
		
		Timber.d("renderBottomNavigationSheet: called")
		
		// Create a BottomNavigationSheetFragment instance and render it
		val bottomNavigationSheetFragment = BottomNavigationSheetFragment()
		bottomNavigationSheetFragment.show(
			supportFragmentManager,
			bottomNavigationSheetFragment.tag
		)
		
		mainActivityViewModel.bottomNavigationSheetRendered() // Reset the LiveData to prevent errors with configuration changes
		
	}
	
	/**
	 * Renders an instance of [AddCounterNoteDialogFragment] and then
	 * resets the [MainActivityViewModel.shouldRenderAddCounterNoteDialogFragment] LiveData value.
	 */
	private fun renderAddCounterNoteDialogFragment() {
		
		Timber.d("renderAddCounterNoteDialogFragment: called")
		
		// Create a AddCounterNoteDialogFragment instance and render it
		val addCounterNoteDialogFragment = AddCounterNoteDialogFragment()
		addCounterNoteDialogFragment.show(
			supportFragmentManager,
			addCounterNoteDialogFragment.tag
		)
		
		mainActivityViewModel.addCounterNoteDialogFragmentRendered() // Reset the LiveData to prevent errors with configuration changes
		
	}
	
}