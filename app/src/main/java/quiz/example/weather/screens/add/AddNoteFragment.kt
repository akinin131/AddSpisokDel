package quiz.example.weather.screens.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import quiz.example.weather.APP
import quiz.example.weather.R
import quiz.example.weather.databinding.FragmentAddBinding
import quiz.example.weather.model.NoteModel


class AddNoteFragment : Fragment() {

    lateinit var bunding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
            APP.navController.navigate(R.id.action_addFragment2_to_startFragment)
        }
        bunding.buttonBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addFragment2_to_startFragment)
        }
    }


}