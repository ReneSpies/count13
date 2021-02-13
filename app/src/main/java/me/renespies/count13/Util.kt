package me.renespies.count13

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 *    Created on: 31 Jan 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

object Util {
	
	object Database {
		
		const val DATABASE_NAME = "count13_database"
		
		object CounterNoteTable {
			
			const val TABLE_NAME = "counter_note_table"
			
			const val TITLE = "title"
			const val DESCRIPTION = "description"
			const val COUNT = "count"
			const val CREATION_DATE = "creation_date"
			
		}
		
	}
	
	/**
	 * BindingAdapter that shortcuts [BottomAppBar.setNavigationOnClickListener] by leveraging
	 * DataBinding. It can be used by XML expressions just like app:onClick on a button.
	 */
	@BindingAdapter("onNavigationItemSelected")
	@JvmStatic
	fun BottomAppBar.onNavigationItemSelected(
		block: () -> Unit
	) {
		
		Timber.d("onNavigationItemSelected: called")
		
		setNavigationOnClickListener { block() }
		
	}
	
	enum class AddNoteFormErrorType {
		
		DEFAULT,
		
		MISSING_TITLE
		
	}
	
	/**
	 * Uses a for-loop to iterate over all direct children of [ConstraintLayout] and
	 * if a child is of type [TextInputLayout], it sets its error property to null and
	 * its isErrorEnabled property to false.
	 */
	fun ConstraintLayout.resetAllTextInputLayoutErrors() {
		
		Timber.d("hideAllTextInputLayoutErrors: called")
		
		for (position in 0 .. childCount) {
			
			val view = getChildAt(position)
			
			if (view is TextInputLayout) {
				
				view.apply {
					
					error = null
					isErrorEnabled = false
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * Disables the button and renders a loading animation on the button's end.
	 */
	fun MaterialButton.disableButtonAndRenderLoadingSpinner() {
		
		Timber.d("disableButtonAndRenderLoadingSpinner: called")
		
		isEnabled = false // Disable the button
		
		// Retrieve the loading spinner from the drawables
		val animatedLoadingSpinner = ResourcesCompat.getDrawable(
			resources,
			R.drawable.animated_loading_spinner,
			null
		) as AnimatedVectorDrawable
		
		animatedLoadingSpinner.start() // Start the animation
		
		// Render the animatedLoadingSpinner on the button's end
		setCompoundDrawablesRelativeWithIntrinsicBounds(
			null,
			null,
			animatedLoadingSpinner,
			null
		)
		
	}
	
	/**
	 * Enables the button, renders a check sign on the button's end and resets it again after 500 milliseconds.
	 */
	fun MaterialButton.enableButtonAndShowCheckSignFor500Milliseconds() {
		
		Timber.d("enableButtonAndShowCheckSignFor500Milliseconds: called")
		
		isEnabled = true // Enable the button
		
		// Retrieve the check sign from the drawables
		val checkSign = ResourcesCompat.getDrawable(
			resources,
			R.drawable.ic_round_check_24,
			null
		)
		
		// Render the check sign on the button's end
		setCompoundDrawablesRelativeWithIntrinsicBounds(
			null,
			null,
			checkSign,
			null
		)
		
		// Reset compoundDrawables after 500 milliseconds
		CoroutineScope(Dispatchers.Main).launch {
			
			delay(500)
			
			enableButtonAndResetCompoundDrawablesWithIntrinsicBounds()
			
		}
		
	}
	
	/**
	 * Enables the the button and sets all compound drawables to null.
	 */
	fun MaterialButton.enableButtonAndResetCompoundDrawablesWithIntrinsicBounds() {
		
		Timber.d("enableButtonAndResetCompoundDrawablesWithIntrinsicBounds: called")
		
		isEnabled = true // Enable the button
		
		// Reset the drawables
		setCompoundDrawablesRelativeWithIntrinsicBounds(
			null,
			null,
			null,
			null
		)
		
	}
	
}