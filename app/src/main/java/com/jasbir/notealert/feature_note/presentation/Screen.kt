package com.jasbir.notealert.feature_note.presentation

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")
}