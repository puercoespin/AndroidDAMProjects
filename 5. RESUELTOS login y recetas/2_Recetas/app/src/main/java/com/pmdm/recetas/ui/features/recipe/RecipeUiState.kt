package com.pmdm.recetas.ui.features.recipe

import androidx.compose.ui.graphics.ImageBitmap

data class RecipeUiState(
    val id:Int,
    val recipeName: String,
    val recipeDescription: String,
    val recipeChef: String,
    var recipeFoto: String?,
    val numberOfLikes: Int,
    val iLike: Boolean
)
