package quiz.example.weather.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import quiz.example.weather.REPOSITORY
import quiz.example.weather.model.NoteModel

class UpdateNoteViewModel : ViewModel() {
    fun update(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.upDateNote(noteModel) {
                onSuccess()
            }
        }
}

