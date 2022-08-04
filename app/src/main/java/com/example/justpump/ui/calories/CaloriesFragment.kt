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
        }

//        viewModel.dailyList.observe(
//            viewLifecycleOwner, Observer {
//                it.filter { it.date == LocalDate.now().toString() }
//            }
//        )
    }

}