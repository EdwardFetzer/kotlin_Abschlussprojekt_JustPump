package com.example.justpump.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.justpump.R
import com.example.justpump.data.model.Exercise
import com.example.justpump.data.model.Training
import com.example.justpump.data.model.TrainingCategory
import com.example.justpump.ui.exercises.ExerciseFragmentDirections

class ExerciseItemAdapter(
    private val context: Context,
    private val dataset: List<Exercise>
) : RecyclerView.Adapter<ExerciseItemAdapter.ItemViewHolder>() {

    //private lateinit var dataset: List<Exercise>

   // @SuppressLint("Test3")
    //fun submitExerciseList(list: List<Exercise>) {
    //    dataset = list
    //    notifyDataSetChanged()
    //}

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_exercise)
        val cvExercise: CardView = itemView.findViewById(R.id.cv_exercise)
        val exerciseTitle: TextView = itemView.findViewById(R.id.tv_exercise_title)
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseItemAdapter.ItemViewHolder {
        val exerciseAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_exercise, parent, false)

        return ExerciseItemAdapter.ItemViewHolder(exerciseAdapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.exerciseTitle.text = context.resources.getString(item.stringResource)
        holder.imageView.setImageResource(item.imageResource)

        holder.cvExercise.setOnClickListener {

            holder.itemView.findNavController()
                .navigate(ExerciseFragmentDirections.actionExerciseFragmentToExerciseDetailFragment())
        }

    }


    override fun getItemCount(): Int {
        return dataset.size
    }
}