package com.example.yumhub.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yuhub.models.RecipeItem
import com.example.yumhub.R

class RecyclerAdapter (private val dataList: ArrayList<RecipeItem>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val recipeImage: ImageView = itemView.findViewById(R.id.recipe_photo)
        val recipeTitle: TextView = itemView.findViewById(R.id.recipe_title)
        val recipeType: TextView = itemView.findViewById(R.id.recipe_meal_type)
        val recipeDifficulty: TextView = itemView.findViewById(R.id.recipe_difficulty)
    }

    interface OnItemClickListener {
        fun onItemClick(item: RecipeItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.recipeDifficulty.text = dataList[position].recipe_difficulty
        holder.recipeType.text = dataList[position].recipe_type
        holder.recipeTitle.text = dataList[position].recipe_title
        holder.recipeImage.setImageResource(dataList[position].recipe_image)

        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}