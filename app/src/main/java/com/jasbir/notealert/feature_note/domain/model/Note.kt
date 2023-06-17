package com.jasbir.notealert.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jasbir.notealert.feature_note.presentation.ui.theme.Blue
import com.jasbir.notealert.feature_note.presentation.ui.theme.Light_Green
import com.jasbir.notealert.feature_note.presentation.ui.theme.Orange
import com.jasbir.notealert.feature_note.presentation.ui.theme.Pink40
import com.jasbir.notealert.feature_note.presentation.ui.theme.Yellow

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Yellow, Blue, Orange, Light_Green, Pink40)
    }
}

class InvalidNoteException(message: String): Exception(message)