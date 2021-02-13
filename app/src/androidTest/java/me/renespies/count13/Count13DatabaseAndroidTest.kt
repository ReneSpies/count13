package me.renespies.count13

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import me.renespies.count13.database.Count13Database
import me.renespies.count13.database.counternotedata.CounterNoteData
import me.renespies.count13.database.counternotedata.CounterNoteDataDao
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber
import java.io.IOException

/**
 *    Created on: 9 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

@RunWith(AndroidJUnit4::class)
class Count13DatabaseAndroidTest {

    private lateinit var counterNoteDataDao: CounterNoteDataDao
    private lateinit var database: Count13Database

    /**
     * Initializes [counterNoteDataDao] and [database].
     */
    @Before
    fun createDatabase() {

        Timber.d("createDatabase: called")

        val context = ApplicationProvider.getApplicationContext<Context>()

        // Get a database instance for the tests
        database = Room.inMemoryDatabaseBuilder(
            context,
            Count13Database::class.java
        ).build()

        counterNoteDataDao = database.getCounterNoteDataDao() // Get the DAO from the database class

    }

    /**
     * Closes the [database] instance.
     *
     * @throws IOException
     */
    @After
    @Throws(IOException::class)
    fun closeDatabase() {

        Timber.d("closeDatabase: called")

        database.close()

    }

    /**
     * Calls methods [write], [read], [update] & [delete].
     *
     * @throws IOException
     */
    @Test
    @Throws(IOException::class)
    fun testCRUD() {

        Timber.d("testCRUD: called")

        write()
        read()
        update()
        delete()

    }

    /**
     * Creates 10 new [CounterNoteData] instances and inserts them into the [database].
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    fun write() = runBlocking {

        Timber.d("write: called")

        for (i in 1..10) {

            val counterNoteData = CounterNoteData(

                id = 0, // Will be auto generated
                title = "title $i",
                description = "description $i",
                count = i,
                creationDate = i.toLong()

            )

            counterNoteDataDao.insert(counterNoteData)

            assertEquals(counterNoteDataDao.getById(i)?.title, counterNoteData.title)

        }

    }

    /**
     * Reads 10 rows from 1 to 10 from the [database].
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    fun read() = runBlocking {

        Timber.d("read: called")

        for (i in 1..10) {

            assertEquals(counterNoteDataDao.getById(i)?.id, i)

        }

    }

    /**
     * Creates 5 new [CounterNoteData] instances and updates 5
     * rows in the [database].
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    fun update() = runBlocking {

        Timber.d("update: called")

        for (i in 3..7) {

            val counterNoteData = CounterNoteData(

                id = i,
                title = "title ${i + 10}",
                description = "description ${i + 10}",
                count = i + 10,
                creationDate = (i + 10).toLong()

            )

            counterNoteDataDao.update(counterNoteData)

            assertEquals(counterNoteDataDao.getById(i), counterNoteData)

        }

    }

    /**
     * Deletes 5 rows from the [database].
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    fun delete() = runBlocking {

        Timber.d("delete: called")

        for (i in 3..7) {

            counterNoteDataDao.deleteById(i)

            assertEquals(counterNoteDataDao.getById(i), null)

        }

    }

}