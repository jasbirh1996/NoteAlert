package com.jasbir.notealert.feature_note.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jasbir.notealert.feature_note.domain.model.Note


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDb: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}