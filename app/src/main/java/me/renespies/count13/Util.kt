package me.renespies.count13

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomappbar.BottomAppBar
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

}