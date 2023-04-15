package quiz.example.weather.db.repository

import androidx.lifecycle.LiveData
import quiz.example.weather.db.dao.NoteDao
import quiz.example.weather.model.NoteModel

class NoteRealization(private val noteDao: NoteDao) : NoteRepository {
    override val AllNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insetrtNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }

    override suspend fun upDateNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.update(noteModel)
        onSuccess()
    }
}