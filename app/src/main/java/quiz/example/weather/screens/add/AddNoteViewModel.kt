package quiz.example.weather.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import quiz.example.weather.REPOSITORY
import quiz.example.weather.model.NoteModel

class AddNoteViewModel : ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {

            REPOSITORY.insetrtNote(noteModel) {
                onSuccess()
            }
        }


}