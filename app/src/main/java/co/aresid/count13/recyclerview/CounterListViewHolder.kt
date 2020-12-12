package co.aresid.count13.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.aresid.count13.databinding.ItemCounterListBinding
import timber.log.Timber


/**
 *    Created on: 12/12/2020
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2020 ARES ID
 */


class CounterListViewHolder private constructor(val binding: ItemCounterListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun from(parent: ViewGroup): CounterListViewHolder {

            Timber.d("from: called")

            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCounterListBinding.inflate(
                layoutInflater,
                parent, false
            )

            return CounterListViewHolder(binding)

        }

    }

}