package com.example.justpump.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.justpump.R
import com.example.justpump.data.model.Training
import com.example.justpump.ui.training.TrainingFragment
import com.example.justpump.ui.training.TrainingFragmentDirections

class TrainingItemAdapter(
    private val context: Context,
    private val dataset: List<Training>
) : RecyclerView.Adapter<TrainingItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.training_cardView)
        val imageView: ImageView = itemView.findViewById(R.id.training_image)
        val trainingTitle: TextView = itemView.findViewById(R.id.training_title_text)
        val startButton: Button = itemView.findViewById(R.id.training_start_button)
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // hier wird das itemLayout gebaut
        val trainingAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_training, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(trainingAdapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.trainingTitle.text = item.title

        holder.startButton.setOnClickListener {
            // wird an ExerciseFragment übergeben
            val bundle = bundleOf("exerciseFilter" to item.category)
            holder.itemView.findNavController()
                .navigate(R.id.exerciseFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}