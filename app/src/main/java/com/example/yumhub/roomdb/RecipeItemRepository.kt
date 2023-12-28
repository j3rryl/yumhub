package com.example.yumhub.roomdb

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class RecipeItemRepository(private val recipeItemDao: RecipeItemDao) {

    val allRecipeItems: Flow<List<RecipeItem>> = recipeItemDao.allRecipeItems()

    @WorkerThread
    suspend fun insertRecipeItem(recipeItem: RecipeItem)
    {
        recipeItemDao.insertRecipeItem(recipeItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(recipeItem: RecipeItem)
    {
        recipeItemDao.updateRecipeItem(recipeItem)
    }
    @WorkerThread
    fun getAllRecipeItems(): List<RecipeItem> {
        return recipeItemDao.getAllRecipeItems()
    }
}