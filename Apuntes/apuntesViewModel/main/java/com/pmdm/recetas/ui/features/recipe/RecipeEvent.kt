package com.pmdm.recetas.ui.features.recipe

sealed interface RecipeEvent{
    object ClickButtonLike:RecipeEvent
}