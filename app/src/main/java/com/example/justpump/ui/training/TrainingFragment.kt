package com.example.justpump.ui.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justpump.R
import com.example.justpump.ViewModel
import com.example.justpump.adapter.ExerciseItemAdapter
import com.example.justpump.adapter.TrainingItemAdapter
import com.example.justpump.databinding.FragmentTrainingBinding


class TrainingFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()
    private lateinit var binding: FragmentTrainingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvTraining

        recyclerView.adapter = viewModel.trainings.value?.let { TrainingItemAdapter(it) }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        recyclerView.setHasFixedSize(true)
    }
}