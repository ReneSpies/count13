package me.renespies.count13.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.renespies.count13.Util
import me.renespies.count13.database.counternotedata.CounterNoteData
import me.renespies.count13.database.counternotedata.CounterNoteDataDao

/**
 *    Created on: 9 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

@Database(
    entities = [CounterNoteData::class],
    version = 1,
    exportSchema = true
)
abstract class Count13Database : RoomDatabase() {

    abstract fun getCounterNoteDataDao(): CounterNoteDataDao

    companion object {

        @Volatile
        private var INSTANCE: Count13Database? = null

        fun getInstance(context: Context): Count13Database =

            INSTANCE ?: synchronized(this) {

                INSTANCE ?: Room.databaseBuilder(
                    context,
                    Count13Database::class.java,
                    Util.Database.DATABASE_NAME
                ).build().also { INSTANCE = it }

            }

    }

}