package me.renespies.count13.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */

class CounterListAdapter : RecyclerView.Adapter<CounterListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CounterListViewHolder {

        Timber.d("onCreateViewHolder: called")

        return CounterListViewHolder.from(parent)

    }

    override fun onBindViewHolder(
        holder: CounterListViewHolder,
        position: Int
    ) {

        Timber.d("onBindViewHolder: called")

    }

    override fun getItemCount() = 100

}