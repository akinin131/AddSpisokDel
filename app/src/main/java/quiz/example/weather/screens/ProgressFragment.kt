package quiz.example.weather.screens

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import quiz.example.weather.screens.ProgressFragment.MyClass.Companion.PointsForCompletedTasksStatic
import quiz.example.weather.data.LevelData
import quiz.example.weather.databinding.FragmentProgressBinding
import quiz.example.weather.viewModel.ViewModelProgress

class ProgressFragment : Fragment() {

    private lateinit var binding: FragmentProgressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgressBinding.inflate(inflater, container, false)

        val levels = LevelData.getLevelUser(requireContext())
        val viewModel = ViewModelProvider(this).get(ViewModelProgress::class.java)

        viewModel.level.observe(viewLifecycleOwner) { level ->

            binding.textView.text = level.toString()
        }

        val newScore = PointsForCompletedTasksStatic
        viewModel.setLevelAndScore(newScore, requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        binding.progressBar.max = 100
        binding.progressBar.progress = PointsForCompletedTasksStatic
        binding.textView.text = PointsForCompletedTasksStatic.toString()
    }

    class MyClass {
        companion object {
            var PointsForCompletedTasksStatic = 0
        }
    }
}