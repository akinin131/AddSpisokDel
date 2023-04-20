package quiz.example.weather.screens.tasks

import android.animation.ObjectAnimator
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import quiz.example.weather.databinding.FragmentTasksBinding
import quiz.example.weather.screens.tasks.Tasks.MyClass.Companion.value

class Tasks : Fragment() {

    private lateinit var binding: FragmentTasksBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTasksBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() {
        binding.progressBar.max = 100

        ObjectAnimator.ofInt(binding.progressBar,"progress",value).setDuration(1000).start()

    }
    class MyClass {
        companion object {
            var value = 0

        }
    }



}