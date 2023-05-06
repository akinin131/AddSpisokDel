package quiz.example.weather.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import quiz.example.weather.databinding.FragmentBottomSheetDetailBinding
import quiz.example.weather.model.NoteModel
import quiz.example.weather.viewModel.DetailNoteViewModel


class BottomSheetDetail : BottomSheetDialogFragment() {

    lateinit var binding: FragmentBottomSheetDetailBinding
    lateinit var currentNote: NoteModel

    companion object {
        fun newInstanceDetail(note: NoteModel): BottomSheetDetail {
            val args = Bundle()
            args.putSerializable("note", note)
            val fragment = BottomSheetDetail()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailNoteViewModel::class.java)

        binding.itemTitle.text = currentNote.title
        binding.Description.text = currentNote.description

        binding.buttonDelete.setOnClickListener {
            viewModel.delete(currentNote) {}
            dismiss()
        }
    }
}