package com.example.yumhub.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecipeItem::class], version = 1, exportSchema = false)
public abstract class RecipeItemDatabase: RoomDatabase() {
    abstract fun recipeItemDao(): RecipeItemDao

    companion object
    {
        @Volatile
        private var INSTANCE: RecipeItemDatabase? = null

        fun getDatabase(context: Context): RecipeItemDatabase
        {
            return INSTANCE ?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeItemDatabase::class.java,
                    "recipe_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}