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
import com.example.justpump.data.model.TrainingCategory
import com.example.justpump.ui.exercises.ExerciseFragmentDirections

class ExerciseItemAdapter(
    private val context: Context,
    private val dataset: List<Exercise>,
    private val onclicklistener: (Exercise) -> Unit
) : RecyclerView.Adapter<ExerciseItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_exercise)
        val cvExercise: CardView = itemView.findViewById(R.id.cv_exercise)
        val exerciseTitle: TextView = itemView.findViewById(R.id.tv_exercise_title)
    }

    /**
     * neue ViewHolder werden erstellt
     * itemLayout wird gebaut
     * und in einem ViewHolder zurückgegeben
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val exerciseAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_exercise, parent, false)

        return ItemViewHolder(exerciseAdapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.exerciseTitle.text = context.resources.getString(item.stringResource)
        holder.imageView.setImageResource(item.imageResource)

        holder.cvExercise.setOnClickListener {
            onclicklistener(item)
        }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }
}