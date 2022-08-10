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
import com.example.justpump.data.model.NutritionCategory
import com.example.justpump.ui.nutrition.NutritionFragmentDirections

class NutritionItemAdapter(
    //private val context: Context,
    private val dataset: List<Nutrition>
) : RecyclerView.Adapter<NutritionItemAdapter.ItemViewHolder>() {

   // private lateinit var dataset: List<Nutrition>

//    @SuppressLint("Test2")
//    fun submitNutritionList(list: List<Nutrition>) {
//        dataset = list
//        notifyDataSetChanged()
//    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvNutrition: CardView = itemView.findViewById(R.id.cv_nutrition)
        val ivNutrition: ImageView = itemView.findViewById(R.id.iv_nutrition)
        val nutritionTitle: TextView = itemView.findViewById(R.id.nutrition_title_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // hier wird das itemLayout gebaut
        val nutritionAdapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_nutrition, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(nutritionAdapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nutritionTitle.text = item.name
        holder.ivNutrition.setImageResource(item.imageResource)

//        holder.cvNutrition.setOnClickListener {
//            holder.itemView.findNavController()
//                .navigate(NutritionFragmentDirections.actionNutritionFragmentToNutritionDetailFragment())
//        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}