package com.example.justpump.ui.nutrition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.justpump.R
import com.example.justpump.databinding.FragmentNutritionDetailBinding


class NutritionDetailFragment : Fragment() {

    private lateinit var binding: FragmentNutritionDetailBinding

    val args: NutritionDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nutrition_detail, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nutrition = args.nutritionItem

        binding.ivNutritionDetail.setImageResource(nutrition.imageResource)
        binding.tvNutritionDetailTitle.text = requireContext().getString(nutrition.stringResource)
        binding.tvNutritionDetailDescriptionText.text = nutrition.description
    }
}