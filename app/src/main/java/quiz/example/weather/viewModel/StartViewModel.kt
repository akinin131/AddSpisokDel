package quiz.example.weather.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import quiz.example.weather.REPOSITORY
import quiz.example.weather.db.NoteDataBase
import quiz.example.weather.db.repository.NoteRealization
import quiz.example.weather.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDataBase() {
        val daoNote = NoteDataBase.getInstance(context).getNotDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.AllNotes
    }
}