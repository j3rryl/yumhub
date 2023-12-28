package com.example.yumhub.roomdb

import android.app.Application
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecipeApplication: Application() {
    private val database by lazy { RecipeItemDatabase.getDatabase(this) }
    val repository by lazy { RecipeItemRepository(database.recipeItemDao()) }
    override fun onCreate() {
        super.onCreate()
        val sampleRecipes = SampleRecipeData.getSampleRecipes()

        GlobalScope.launch(Dispatchers.IO) {
            if(repository.getAllRecipeItems().isEmpty()) {
                for (recipe in sampleRecipes) {
                    repository.insertRecipeItem(recipe)
                }
            }
        }
    }
}