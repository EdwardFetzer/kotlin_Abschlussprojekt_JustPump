package com.example.justpump.ui.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justpump.R
import com.example.justpump.adapter.ExerciseItemAdapter
import com.example.justpump.data.ExerciseDatasource
import com.example.justpump.data.model.Exercise
import com.example.justpump.data.model.ExerciseCategory
import com.example.justpump.databinding.FragmentExerciseBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ExerciseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExerciseFragment : Fragment() {
    private lateinit var binding: FragmentExerciseBinding
    private val viewModel: ExerciseViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

      //  val exercises =
        // rohdaten (komplette liste)
        val exercisesTemp = ExerciseDatasource().loadExercises()

        // gefilterte daten
        val exercises = mutableListOf<Exercise>()

        // von TrainingFragment übergebene Kategorie
        val exerciseFilter = arguments?.get("exerciseFilter")

        //gehe durch alle rohdaten
        for (i in 0 until exercisesTemp.size) {
            // speichere ob vorhanden
            var existing = false

            // gehe durch alle Kategorien einer Exercise
            for (j in exercisesTemp[i].categories) {
                // wenn übergebene Kategorie = Kategorie in Exercise
                if (j == exerciseFilter) {
                    existing = true
                }
            }
            // wenn Kategorie vorhanden -> speichere in (val exercises)
            if (existing) {
                exercises.add(exercisesTemp[i])
            }
        }

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.rvExercise

        // recyclerView erhält einen passenden LayoutManager
        recyclerView.layoutManager = GridLayoutManager(requireContext(),1)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ExerciseItemAdapter(requireContext(), exercises)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }
}