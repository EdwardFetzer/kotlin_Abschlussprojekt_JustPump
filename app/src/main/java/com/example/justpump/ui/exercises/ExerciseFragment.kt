package com.example.justpump.ui.exercises

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justpump.R
import com.example.justpump.ViewModel
import com.example.justpump.adapter.ExerciseItemAdapter
import com.example.justpump.adapter.TrainingItemAdapter
import com.example.justpump.data.model.Exercise
import com.example.justpump.databinding.FragmentExerciseBinding


class ExerciseFragment : Fragment() {

    private lateinit var binding: FragmentExerciseBinding
    private val viewModel: ViewModel by activityViewModels()
    private var category: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            category = it.getString("exerciseCategoryARG").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.exercises.observe(
            viewLifecycleOwner,
            Observer { list ->
                val exercises = list.filter { it.category == category }

                binding.rvExercise.adapter = ExerciseItemAdapter(requireContext(), exercises) {partitem : Exercise ->
                    findNavController().navigate(
                        ExerciseFragmentDirections.actionExerciseFragmentToExerciseDetailFragment(partitem)
                    )
                }

                binding.rvExercise.layoutManager = GridLayoutManager(requireContext(), 2)

                binding.rvExercise.setHasFixedSize(true)
            }
        )
    }
}