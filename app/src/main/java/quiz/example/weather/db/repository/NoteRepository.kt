package quiz.example.weather.db.repository

import androidx.lifecycle.LiveData
import quiz.example.weather.model.NoteModel

interface NoteRepository {
    val AllNotes: LiveData<List<NoteModel>>
    suspend fun insetrtNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun upDateNote(noteModel: NoteModel, onSuccess: () -> Unit)
}