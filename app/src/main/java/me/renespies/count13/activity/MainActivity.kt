package me.renespies.count13.activity

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import me.renespies.count13.databinding.ActivityMainBinding
import me.renespies.count13.fragment.addcounternote.AddCounterNoteDialogFragment
import me.renespies.count13.fragment.bottomnavigationsheet.BottomNavigationSheetFragment
import timber.log.Timber

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Binding for the layout
    private lateinit var mainActivityViewModel: MainActivityViewModel // Corresponding ViewModel

    @RequiresApi(Build.VERSION_CODES.M)
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
     * Inflates and renders a [BottomNavigationSheetFragment].
     */
    private fun renderBottomNavigationSheet() {
	
	    Timber.d("renderBottomNavigationSheet: called")
	
	    val bottomNavigationSheetFragment = BottomNavigationSheetFragment()
	    bottomNavigationSheetFragment.show(
		    supportFragmentManager,
		    bottomNavigationSheetFragment.tag
	    )
	
    }
	
	private fun renderAddCounterNoteDialogFragment() {
		
		Timber.d("renderAddCounterNoteDialogFragment: called")
		
		val addCounterNoteDialogFragment = AddCounterNoteDialogFragment()
		addCounterNoteDialogFragment.show(
			supportFragmentManager,
			addCounterNoteDialogFragment.tag
		)
		
	}
	
}