package com.example.justpump.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.justpump.R
import com.example.justpump.data.model.TrainingCategory
import com.example.justpump.ui.home.HomeFragmentDirections

class HomeItemAdapter (
    private val dataset: List<TrainingCategory>
) : RecyclerView.Adapter<HomeItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvTraining: CardView = itemView.findViewById(R.id.cv_training)
        val imageView: ImageView = itemView.findViewById(R.id.training_image)
        val trainingTitle: TextView = itemView.findViewById(R.id.tv_training_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val homeAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_training, parent, false)

        return ItemViewHolder(homeAdapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.trainingTitle.text = item.name
        holder.imageView.setImageResource(item.imageResource)

        holder.cvTraining.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToExerciseFragment(item.name))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}