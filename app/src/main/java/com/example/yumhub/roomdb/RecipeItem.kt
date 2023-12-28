package com.example.yumhub.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_item_table")
class RecipeItem (
    @ColumnInfo(name = "recipe_type") var recipe_type: String,
    @ColumnInfo(name = "recipe_title") var recipe_title: String,
    @ColumnInfo(name = "recipe_quantity") var recipe_quantity: Int,
    @ColumnInfo(name = "recipe_difficulty") var recipe_difficulty:String,
    @ColumnInfo(name = "recipe_ingredients") var recipe_ingredients:String,
    @ColumnInfo(name = "recipe_preparation_steps") var recipe_preparation_steps:String,
    @ColumnInfo(name = "recipe_image") var recipe_image: Int,
    @PrimaryKey(autoGenerate = true) var id:Int=0
)
{


}