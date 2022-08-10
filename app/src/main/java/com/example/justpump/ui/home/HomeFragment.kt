package com.example.justpump.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justpump.R
import com.example.justpump.databinding.FragmentHomeBinding
import com.example.justpump.ViewModel
import com.example.justpump.adapter.HomeItemAdapter
import com.example.justpump.adapter.TrainingItemAdapter


class HomeFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvRandomTraining

        recyclerView.adapter = viewModel.trainings.value?.let { HomeItemAdapter(it) }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.setHasFixedSize(true)
    }
}