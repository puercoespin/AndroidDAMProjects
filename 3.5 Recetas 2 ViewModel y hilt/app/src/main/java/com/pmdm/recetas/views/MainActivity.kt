package com.pmdm.recetas.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.pmdm.recetas.R
import com.pmdm.recetas.ui.features.recipe.RecipeScreen
import com.pmdm.recetas.ui.features.recipe.RecipeViewModel
import com.pmdm.recetas.ui.theme.RecetasTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: RecipeViewModel by viewModels()
        setContent {
            RecetasTheme {
                // A surface container using the 'background' color from the theme
                viewModel.recipeState=viewModel.recipeState.copy(
                    recipeFoto= ImageBitmap.imageResource(this.resources, R.drawable.magdalenas)
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeScreen(
                        recipe=viewModel.recipeState,
                        onRecipeEvent = viewModel::onRecipeEvent
                    )
                }
            }
        }
    }
}
