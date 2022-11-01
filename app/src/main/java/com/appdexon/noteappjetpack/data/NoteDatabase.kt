package com.appdexon.noteappjetpack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appdexon.noteappjetpack.model.Note
import com.appdexon.noteappjetpack.util.DateConverter
import com.appdexon.noteappjetpack.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}