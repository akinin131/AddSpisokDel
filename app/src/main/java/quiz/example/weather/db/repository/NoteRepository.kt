package quiz.example.weather.db.repository

import androidx.lifecycle.LiveData
import quiz.example.weather.model.NoteModel

interface NoteRepository {
    val AllNotes:LiveData<List<NoteModel>>
    suspend fun insetrNote(noteModel: NoteModel, onSuccess:()-> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:()-> Unit)
}