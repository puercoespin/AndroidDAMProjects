package com.pmdm.recetas.ui.features.recipe

import androidx.compose.ui.graphics.ImageBitmap

data class RecipeUiState(
    val recipeName: String,
    val recipeDescription: String,
    val recipeChef: String,
    var recipeFoto: ImageBitmap?,
    val numberOfLikes: Int,
    val iLike: Boolean
)
