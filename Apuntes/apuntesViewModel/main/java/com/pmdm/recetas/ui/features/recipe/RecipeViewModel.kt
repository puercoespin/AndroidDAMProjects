package com.pmdm.recetas.ui.features.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.recetas.data.RecipeRepository
import com.pmdm.recetas.data.toRecipe
import com.pmdm.recetas.data.toRecipeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(    private val repository: RecipeRepository ): ViewModel() {

    var recipeState by mutableStateOf(loadRecipe())

    fun loadRecipe(): RecipeUiState {
        var recipe = repository.get()
        return recipe.toRecipeUiState()
    }

    fun onRecipeEvent(event: RecipeEvent) {
        when (event) {
            is RecipeEvent.ClickButtonLike -> {
                val newLikes =
                    if (!recipeState.iLike) recipeState.numberOfLikes + 1 else recipeState.numberOfLikes - 1
                recipeState = recipeState.copy(
                    iLike = !recipeState.iLike,
                    numberOfLikes = newLikes
                )
                repository.updateRecipe(recipeState.toRecipe())
            }
        }
    }
}

