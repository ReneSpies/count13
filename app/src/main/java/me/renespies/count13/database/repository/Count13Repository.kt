package me.renespies.count13.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import me.renespies.count13.database.Count13Database
import me.renespies.count13.database.counternotedata.CounterNoteData
import me.renespies.count13.database.counternotedata.CounterNoteDataDao

/**
 *    Created on: 9 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

class Count13Repository private constructor(private val application: Application) {

    private lateinit var count13Database: Count13Database

    private val counterNoteDataDao: CounterNoteDataDao by lazy {

        if (!::count13Database.isInitialized) {

            count13Database = Count13Database.getInstance(application.applicationContext)

        }

        count13Database.getCounterNoteDataDao()

    }

    /**
     * @see [CounterNoteDataDao.insert].
     */
    suspend fun insertCounterNote(data: CounterNoteData) = counterNoteDataDao.insert(data)

    /**
     * @see [CounterNoteDataDao.update].
     */
    suspend fun updateCounterNote(data: CounterNoteData) = counterNoteDataDao.update(data)

    /**
     * @see [CounterNoteDataDao.deleteById].
     */
    suspend fun deleteCounterNoteById(id: Int) = counterNoteDataDao.deleteById(id)

    /**
     * @see [CounterNoteDataDao.getById].
     */
    suspend fun getCounterNoteById(id: Int) = counterNoteDataDao.getById(id)

    /**
     * @see [CounterNoteDataDao.getAll].
     */
    suspend fun getAllCounterNotes(): List<CounterNoteData> = counterNoteDataDao.getAll()

    /**
     * @see [CounterNoteDataDao.getAllLiveData].
     */
    fun getAllCounterNotesLiveData(): LiveData<List<CounterNoteData>> = counterNoteDataDao.getAllLiveData()

    // Makes this class a singleton
    companion object {

        @Volatile
        private var INSTANCE: Count13Repository? = null

        fun getInstance(application: Application): Count13Repository =

            INSTANCE ?: synchronized(this) {

                INSTANCE ?: Count13Repository(application).also { INSTANCE = it }

            }

    }

}