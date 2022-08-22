package quiz.example.weather.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import quiz.example.weather.APP
import quiz.example.weather.R
import quiz.example.weather.databinding.FragmentDetailBinding
import quiz.example.weather.model.NoteModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote:NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailBinding.inflate(layoutInflater,container,false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.itemTitle.text = currentNote.title
        binding.Description.text = currentNote.description

        binding.buttonDelete.setOnClickListener {
            viewModel.delete(currentNote){}
                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)

        }

        binding.buttonBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

    }


}