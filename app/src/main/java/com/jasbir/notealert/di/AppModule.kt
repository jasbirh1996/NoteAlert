package com.jasbir.notealert.di

import android.app.Application
import androidx.room.Room
import com.jasbir.notealert.feature_note.data.local_db.NoteDao
import com.jasbir.notealert.feature_note.data.local_db.NoteDb
import com.jasbir.notealert.feature_note.data.repository.NoteRepositoryImpl
import com.jasbir.notealert.feature_note.domain.repository.NoteRepository
import com.jasbir.notealert.feature_note.domain.use_case.AddNoteUseCase
import com.jasbir.notealert.feature_note.domain.use_case.DeleteNoteUseCase
import com.jasbir.notealert.feature_note.domain.use_case.GetNoteByIdUseCase
import com.jasbir.notealert.feature_note.domain.use_case.GetNotesUseCase
import com.jasbir.notealert.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDb {
        return Room.databaseBuilder(
            app,
            NoteDb::class.java,
            NoteDb.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDb): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository),
            getNoteById = GetNoteByIdUseCase(repository)
        )
    }
}