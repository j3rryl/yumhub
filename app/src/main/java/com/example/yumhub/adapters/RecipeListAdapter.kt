package com.example.yumhub.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.yuhub.models.RecipeItem
import com.example.yumhub.R

class RecipeListAdapter(private val context: Activity, private val arrayList: ArrayList<RecipeItem>): ArrayAdapter<RecipeItem>(context,
    R.layout.recipe_card, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.recipe_card, null)

        val recipeImage: ImageView = view.findViewById(R.id.recipe_photo)
        val recipeTitle: TextView = view.findViewById(R.id.recipe_title)
        val recipeType: TextView = view.findViewById(R.id.recipe_meal_type)
        val recipeDifficulty: TextView = view.findViewById(R.id.recipe_difficulty)

        recipeImage.setImageResource(arrayList[position].recipe_image)
        recipeTitle.text=arrayList[position].recipe_title
        recipeType.text=arrayList[position].recipe_type
        recipeDifficulty.text=arrayList[position].recipe_difficulty
        if(recipeDifficulty.text=="Beginner"){
            recipeDifficulty.setTextColor(ContextCompat.getColor(context, R.color.green))
        }
        else if(recipeDifficulty.text=="Intermediate"){
            recipeDifficulty.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        }
        else if(recipeDifficulty.text=="Advanced"){
            recipeDifficulty.setTextColor(ContextCompat.getColor(context, R.color.red))
        }

        return view
    }
}