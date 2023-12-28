package com.example.yumhub.roomdb

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeItemRepository) : ViewModel() {
    val allRecipeItems: LiveData<List<RecipeItem>> = repository.allRecipeItems.asLiveData()
    private val _navigateToRecipeDetail = MutableLiveData<RecipeItem?>()

    fun insert(recipeItem: RecipeItem) {
        viewModelScope.launch {
            repository.insertRecipeItem(recipeItem)
        }
    }
    fun onRecipeItemClicked(recipe: RecipeItem) {
        _navigateToRecipeDetail.value = recipe
    }

    fun onRecipeDetailNavigated() {
        _navigateToRecipeDetail.value = null
    }

}
class RecipeItemModelFactory(private val repository: RecipeItemRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(RecipeViewModel::class.java))
            return RecipeViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}