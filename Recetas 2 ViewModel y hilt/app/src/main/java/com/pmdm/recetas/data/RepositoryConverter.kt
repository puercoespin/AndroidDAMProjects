package com.pmdm.recetas.data

import arquitectura_usuario.data.mocks.RecipeMock
import com.pmdm.recetas.models.Recipe
import com.pmdm.recetas.ui.features.recipe.RecipeUiState

fun RecipeMock.toRecipe(): Recipe = Recipe(
    this.name,
    this.description,
    this.chef,
    this.photo,
    this.likes,
    this.isLiked
)

fun Recipe.toRecipeMock(): RecipeMock = RecipeMock(
    this.name,
    this.description,
    this.chef,
    this.photo,
    this.likes,
    this.isLiked
)

fun Recipe.toRecipeUiState(): RecipeUiState =RecipeUiState(
    this.name,
    this.description,
    this.chef,
    this.photo,
    this.likes,
    this.isLiked
)

fun RecipeUiState.toRecipe():Recipe= Recipe(
    this.recipeName,
    this.recipeDescription,
    this.recipeChef,
    this.recipeFoto,
    this.numberOfLikes,
    this.iLike
)