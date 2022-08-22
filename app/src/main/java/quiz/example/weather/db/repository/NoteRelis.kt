package quiz.example.weather.db.repository

import androidx.lifecycle.LiveData
import quiz.example.weather.db.dao.NotDao
import quiz.example.weather.model.NoteModel

class NoteRelis(private val noteDao: NotDao):NoteRepository{
    override val AllNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insetrNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}