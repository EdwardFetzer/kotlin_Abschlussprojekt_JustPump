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
import com.example.justpump.adapter.TrainingItemAdapter
import com.example.justpump.data.TrainingDatasource
import com.example.justpump.databinding.FragmentTrainingBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TrainingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrainingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentTrainingBinding
    private val viewModel: TrainingViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false)

            // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trainings = TrainingDatasource().loadTraining()

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.rvTraining

        // recyclerView erhält einen passenden LayoutManager
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = TrainingItemAdapter(requireContext(), trainings)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }
}