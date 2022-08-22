package quiz.example.weather.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import quiz.example.weather.REPOSITORY
import quiz.example.weather.db.NotDataBase
import quiz.example.weather.db.repository.NoteRelis
import quiz.example.weather.model.NoteModel

class StartViewModel(application:Application):AndroidViewModel(application) {

    val context = application

    fun initDataBase(){
        val daoNote = NotDataBase.getInstance(context).getNotDao()
        REPOSITORY =NoteRelis(daoNote)
    }
    fun getAllNotes():LiveData<List<NoteModel>>{
        return REPOSITORY.AllNotes
    }
}