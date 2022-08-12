package com.example.justpump.ui.exercises

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.justpump.R
import com.example.justpump.ViewModel
import com.example.justpump.databinding.FragmentExerciseDetailBinding


class ExerciseDetailFragment : Fragment() {

    private lateinit var binding: FragmentExerciseDetailBinding

    val args: ExerciseDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise_detail, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val exercise = args.exerciseItem

        binding.ivExerciseDetail.setImageResource(exercise.imageResource)
        binding.tvExerciseDetailTitle.text = requireContext().getString(exercise.stringResource)
        binding.tvExerciseDetailDescriptionText.text = exercise.description
    }
}