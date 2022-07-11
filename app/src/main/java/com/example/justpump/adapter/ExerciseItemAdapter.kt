package com.example.justpump.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justpump.R
import com.example.justpump.data.model.Exercise

class ExerciseItemAdapter(
    private val context: Context,
    private val dataset: List<Exercise>
) : RecyclerView.Adapter<ExerciseItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseTitle: TextView = itemView.findViewById(R.id.tv_exercise_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseItemAdapter.ItemViewHolder {
        val exerciseAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_exercise, parent, false)

        return ExerciseItemAdapter.ItemViewHolder(exerciseAdapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.exerciseTitle.text = item.title

    }


    override fun getItemCount(): Int {
        return dataset.size
    }
}