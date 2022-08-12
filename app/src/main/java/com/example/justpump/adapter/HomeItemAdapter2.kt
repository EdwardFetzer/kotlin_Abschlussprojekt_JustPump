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
import com.example.justpump.data.model.Nutrition
import com.example.justpump.ui.home.HomeFragmentDirections

class HomeItemAdapter2 (
    private val dataset: List<Nutrition>
        ) : RecyclerView.Adapter<HomeItemAdapter2.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvNutrition: CardView = itemView.findViewById(R.id.cv_nutrition)
        val ivNutrition: ImageView = itemView.findViewById(R.id.iv_nutrition)
        val nutritionTitle: TextView = itemView.findViewById(R.id.nutrition_title_text)
    }

    /**
     * neue ViewHolder werden erstellt
     * itemLayout wird gebaut
     * und in einem ViewHolder zurückgegeben
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val homeAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_nutrition, parent, false)

        return ItemViewHolder(homeAdapterLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter werden verändert
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nutritionTitle.text = item.name
        holder.ivNutrition.setImageResource(item.imageResource)

        holder.cvNutrition.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToNutritionDetailFragment(item))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}