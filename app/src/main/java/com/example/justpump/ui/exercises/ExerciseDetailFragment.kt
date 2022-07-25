package com.example.justpump.ui.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.justpump.R
import com.example.justpump.ViewModel
import com.example.justpump.databinding.FragmentExerciseDetailBinding


class ExerciseDetailFragment : Fragment() {

    private lateinit var binding: FragmentExerciseDetailBinding
    private val viewModel: ViewModel by activityViewModels()

    private var exerciseId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            exerciseId = it.getLong("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise_detail, container, false)

        return binding.root
    }
}