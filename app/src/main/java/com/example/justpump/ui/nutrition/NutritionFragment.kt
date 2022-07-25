package com.example.justpump.ui.nutrition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justpump.R
import com.example.justpump.ViewModel
import com.example.justpump.adapter.NutritionItemAdapter
import com.example.justpump.data.NutritionDatasource
import com.example.justpump.databinding.FragmentNutritionBinding


class NutritionFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()

    private lateinit var binding: FragmentNutritionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nutrition, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nutritionAdapter = NutritionItemAdapter(requireContext())

        binding.rvNutrition.adapter = nutritionAdapter

        viewModel.nutrition.observe(
            viewLifecycleOwner,
            Observer {
                nutritionAdapter.submitNutritionList(it)
            }
        )

        // recyclerView erhält einen passenden LayoutManager
        binding.rvNutrition.layoutManager = GridLayoutManager(requireContext(), 2)

    }
}