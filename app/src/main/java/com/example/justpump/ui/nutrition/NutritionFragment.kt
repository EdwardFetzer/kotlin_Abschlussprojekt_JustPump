package com.example.justpump.ui.nutrition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justpump.R
import com.example.justpump.adapter.NutritionItemAdapter
import com.example.justpump.data.NutritionDatasource
import com.example.justpump.databinding.FragmentNutritionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NutritionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NutritionFragment : Fragment() {
    private lateinit var binding: FragmentNutritionBinding
    private val viewModel: NutritionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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

        val nutritions = NutritionDatasource().loadNutritions()

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.rvNutrition

        // recyclerView erhält einen passenden LayoutManager
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = NutritionItemAdapter(requireContext(), nutritions)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)

    }
}