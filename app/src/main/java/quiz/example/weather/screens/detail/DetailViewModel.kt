package quiz.example.weather.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import quiz.example.weather.REPOSITORY
import quiz.example.weather.model.NoteModel

class DetailViewModel : ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess:() -> Unit)=
        viewModelScope.launch  (Dispatchers.IO){
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
}