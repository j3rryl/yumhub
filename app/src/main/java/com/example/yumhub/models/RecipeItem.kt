package com.example.yuhub.models

data class RecipeItem(
    var recipe_type: String,
    var recipe_title: String,
    var recipe_quantity: Int,
    var recipe_difficulty:String,
    var recipe_ingredients:String,
    var recipe_preparation_steps:String,
    var recipe_image: Int
)
