package com.example.justpump.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.justpump.R
import com.example.justpump.databinding.FragmentHomeBinding
import com.example.justpump.ViewModel


class HomeFragment : Fragment() {

    private val viewmodel: ViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val recyclerView = binding.recyclerViewHome

        //recyclerView.adapter = ItemAdapter()
    }
}