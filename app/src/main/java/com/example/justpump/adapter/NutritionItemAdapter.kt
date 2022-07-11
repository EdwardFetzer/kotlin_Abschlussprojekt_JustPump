package com.example.justpump.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justpump.R
import com.example.justpump.data.NutritionDatasource
import com.example.justpump.data.model.Nutrition

class NutritionItemAdapter(
    private val context: Context,
    private val dataset: List<Nutrition>
) : RecyclerView.Adapter<NutritionItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nutritionTitle: TextView = itemView.findViewById(R.id.nutrition_title_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionItemAdapter.ItemViewHolder {

        // hier wird das itemLayout gebaut
        val nutritionAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_nutrition, parent, false)

        // und in einem ViewHolder zurückgegeben
        return NutritionItemAdapter.ItemViewHolder(nutritionAdapterLayout)
    }

    override fun onBindViewHolder(holder: NutritionItemAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nutritionTitle.text = item.title
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}