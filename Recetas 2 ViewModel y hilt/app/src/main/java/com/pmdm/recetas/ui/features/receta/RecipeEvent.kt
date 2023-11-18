package com.pmdm.recetas.ui.features.receta

sealed interface RecipeEvent{
    object ClickButtonLike:RecipeEvent
}