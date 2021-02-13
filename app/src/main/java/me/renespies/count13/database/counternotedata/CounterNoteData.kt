package me.renespies.count13.database.counternotedata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.renespies.count13.Util

/**
 *    Created on: 9 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */

@Entity(tableName = Util.Database.CounterNoteTable.TABLE_NAME)
data class CounterNoteData(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = Util.Database.CounterNoteTable.TITLE) val title: String,

    @ColumnInfo(name = Util.Database.CounterNoteTable.DESCRIPTION) val description: String,

    @ColumnInfo(name = Util.Database.CounterNoteTable.COUNT) val count: Int,

    @ColumnInfo(name = Util.Database.CounterNoteTable.CREATION_DATE) val creationDate: Long

)
