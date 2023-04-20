package quiz.example.weather.screens.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import quiz.example.weather.databinding.FragmentAddBinding
import quiz.example.weather.model.NoteModel


class AddNoteFragment : BottomSheetDialogFragment() {

    lateinit var bunding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bunding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return bunding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        bunding.buttonAdd.setOnClickListener {
            val title = bunding.etAddTitle.text.toString()
            val description = bunding.etAddDesc.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)) {}
            dismiss()
        }
    }
}