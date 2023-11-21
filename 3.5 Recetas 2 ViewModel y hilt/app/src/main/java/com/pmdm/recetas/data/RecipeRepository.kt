package com.pmdm.recetas.data

import arquitectura_usuario.data.mocks.RecipeDaoMock
import com.pmdm.recetas.models.Recipe
import javax.inject.Inject

class RecipeRepository @Inject constructor(val proveedorRecipe: RecipeDaoMock) {

    fun get(): Recipe =proveedorRecipe.get().toRecipe()
    fun updateRecipe(recipe: Recipe)=proveedorRecipe.updateRecipe(recipe.toRecipeMock())

}