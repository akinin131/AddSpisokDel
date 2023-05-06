package quiz.example.weather.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import quiz.example.weather.adapter.NoteAdapter
import quiz.example.weather.databinding.FragmentStartBinding
import quiz.example.weather.viewModel.StartViewModel

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter
    var preferences: SharedPreferences? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        preferences = requireActivity().getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        ProgressFragment.MyClass.PointsForCompletedTasksStatic = preferences?.getInt("counter", 0)!!

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDataBase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->

            adapter.setList(listNotes.asReversed())

        }

        binding.AddNoteBtn.setOnClickListener {
            val bottomSheetDialog = AddNoteFragment()
            bottomSheetDialog.show(parentFragmentManager, "AddNoteFragment")
        }
    }

    @SuppressLint("CommitPrefEdits")
    fun saveData(res: Int) {
        val editor = preferences?.edit()
        editor?.putInt("counter", res)
        editor?.apply()
    }

    override fun onDestroyView() {
        saveData(ProgressFragment.MyClass.PointsForCompletedTasksStatic)
        super.onDestroyView()
    }
}