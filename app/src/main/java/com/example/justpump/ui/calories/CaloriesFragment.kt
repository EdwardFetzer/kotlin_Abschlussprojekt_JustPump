package com.example.justpump.ui.calories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.justpump.R
import com.example.justpump.ViewModel
import com.example.justpump.databinding.FragmentCaloriesBinding
import kotlinx.coroutines.launch
import java.time.LocalDate


class CaloriesFragment : Fragment() {

    private lateinit var binding: FragmentCaloriesBinding
    private val viewModel: ViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calories, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val foodName = binding.textInputEditText.text.toString()
            viewModel.getMacrosAndInsert(foodName)
            viewModel.getMacros(foodName)
        }

        viewModel.macros.observe(
            viewLifecycleOwner, Observer {
                binding.tvName.text = it.name
                binding.tvServingSize.text = it.serving_size_g.toString()
                binding.tvCalories.text = it.calories.toString()
                binding.tvFatTotal.text = it.fat_total_g.toString()
                binding.tvFatSaturated.text = it.fat_saturated_g.toString()
                binding.tvCholeterol.text = it.cholesterol_mg.toString()
                binding.tvSodium.text = it.sodium_mg.toString()
                binding.tvPotassium.text = it.potassium_mg.toString()
                binding.tvCarbohydrates.text = it.carbohydrates_total_g.toString()
                binding.tvSugar.text = it.sugar_g.toString()
                binding.tvProtein.text = it.protein_g.toString()
            }
        )

//        viewModel.dailyList.observe(
//            viewLifecycleOwner, Observer {
//                it.filter { it.date == LocalDate.now().toString() }
//            }
//        )
    }

}