package me.renespies.count13.database.counternotedata

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *    Created on: 9 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

@Dao
interface CounterNoteDataDao {

    /**
     * Uses the [androidx.room.Insert] annotation with [OnConflictStrategy.REPLACE] to insert data into the
     * database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(counterNoteData: CounterNoteData)

    /**
     * Uses the [androidx.room.Update] annotation to update data in the database.
     */
    @Update
    suspend fun update(counterNoteData: CounterNoteData)

    /**
     * Uses the [androidx.room.Query] annotation to return all rows from the database.
     *
     * @return [LiveData] with type [List] with type [CounterNoteData] representing all rows in the database.
     */
    @Query("SELECT * FROM counter_note_table")
    fun getAllLiveData(): LiveData<List<CounterNoteData>>

    /**
     * Uses the [androidx.room.Query] annotation to return all rows from the database.
     *
     * @return [List] with type [CounterNoteData] representing all rows in the database.
     */
    @Query("SELECT * FROM counter_note_table")
    suspend fun getAll(): List<CounterNoteData>

    /**
     * Uses the [androidx.room.Query] annotation to return all rows from the database where [id] matches.
     *
     * @return [CounterNoteData] representing a matching row or null.
     */
    @Query("SELECT * FROM counter_note_table WHERE id = :id")
    suspend fun getById(id: Int): CounterNoteData?

    /**
     * Uses the [androidx.room.Query] annotation to delete all rows in the database where [id] matches.
     */
    @Query("DELETE FROM counter_note_table WHERE id = :id")
    suspend fun deleteById(id: Int)

}