package com.example.justpump.ui.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.justpump.R
import com.example.justpump.adapter.TrainingItemAdapter
import com.example.justpump.data.TrainingDatasource
import com.example.justpump.databinding.FragmentTrainingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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

        val trainings = TrainingDatasource().loadTraining()

        val recyclerView = binding.rvTraining

        recyclerView.adapter = TrainingItemAdapter(this, trainings)

            // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training, container, false)
    }
}