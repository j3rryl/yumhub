package com.example.yumhub.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.yumhub.R
import com.example.yumhub.roomdb.RecipeItem
import com.example.yumhub.roomdb.RecipeItemDatabase
import com.example.yumhub.roomdb.RecipeItemRepository
import kotlinx.coroutines.launch

class RecyclerAdapter (private val context: Activity, private val dataList: ArrayList<RecipeItem>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val recipeImage: ImageView = itemView.findViewById(R.id.recipe_photo)
        val recipeTitle: TextView = itemView.findViewById(R.id.recipe_title)
        val recipeType: TextView = itemView.findViewById(R.id.recipe_meal_type)
        val removeButton: Button = itemView.findViewById(R.id.remove_recipe_button)
        val recipeDifficulty: TextView = itemView.findViewById(R.id.recipe_difficulty)
    }

    interface OnItemClickListener {
        fun onItemClick(item: RecipeItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recipe_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val database by lazy { RecipeItemDatabase.getDatabase(context) }
        val repository by lazy { RecipeItemRepository(database.recipeItemDao()) }

        val item = dataList[position]
        holder.recipeDifficulty.text = dataList[position].recipe_difficulty
        holder.recipeType.text = dataList[position].recipe_type
        holder.recipeTitle.text = dataList[position].recipe_title
        holder.recipeImage.setImageResource(dataList[position].recipe_image)

        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(item)
        }
        holder.removeButton.setOnClickListener {
            if (context is FragmentActivity) {
                context.lifecycleScope.launch {
                    repository.deleteRecipeItem(item)
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun clear() {
        dataList.clear()
        notifyDataSetChanged()
    }

    // Add a list of items to the dataList
    fun addAll(items: List<RecipeItem>) {
        dataList.addAll(items)
        notifyDataSetChanged()
    }
}