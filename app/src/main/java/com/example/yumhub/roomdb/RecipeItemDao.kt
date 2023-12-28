package com.example.yumhub.roomdb

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeItemDao {
    @Query("SELECT * FROM recipe_item_table ORDER BY id ASC")
    fun allRecipeItems(): Flow<List<RecipeItem>>

    @Query("SELECT * FROM recipe_item_table")
    fun getAllRecipeItems(): List<RecipeItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeItem(recipeItem: RecipeItem)

    @Update
    suspend fun updateRecipeItem(taskItem: RecipeItem)

    @Delete
    suspend fun deleteRecipeItem(taskItem: RecipeItem)
}