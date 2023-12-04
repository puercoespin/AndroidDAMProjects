package com.pmdm.recetas.ui.features.receta

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.pmdm.recetas.R
import com.pmdm.recetas.ui.composables.buttonlike.ButtonLike
import com.pmdm.recetas.ui.theme.RecetasTheme

@Composable
fun Receta(
    iLike: ButtonLikeUiState,
    recipeName: String,
    recipeDescription: String,
    recipeChef: String,
    recipeFoto: ImageBitmap?,
    onILikePressed: () -> Unit
) {
    var painterFoto = recipeFoto?.let { remember { BitmapPainter(it) } }
        ?: rememberVectorPainter(image = Icons.Filled.Dining)
    Card(
        modifier = Modifier.wrapContentSize()
    ) {
        Column {
            Surface(
                modifier = Modifier.clip(CardDefaults.shape),
                color = MaterialTheme.colorScheme.primary
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterFoto,
                    contentDescription = recipeName,
                    contentScale = ContentScale.FillWidth,
                    alpha = 0.90f
                )
            }
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                text = recipeName,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                text = recipeDescription,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.size(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = recipeChef,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
                ButtonLike(
                    iLike = iLike.iLike,
                    numberOfLikes = iLike.numberOfLikes,
                    onILikePressed = onILikePressed
                )
            }
        }
    }
}

class ConImagenRecetaProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(true, false)
}

@Preview(showBackground = true)
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun RecetaPreview(@PreviewParameter(ConImagenRecetaProvider::class) conImagen: Boolean) {
    var iLikeState by remember {
        mutableStateOf(
            ButtonLikeUiState(
                numberOfLikes = 8,
                iLike = false
            )
        )
    }

    var onLocallyLikePressed = {
        iLikeState = iLikeState.copy(
            numberOfLikes = iLikeState.numberOfLikes +
                    if (!iLikeState.iLike) 1 else -1,
            iLike = !iLikeState.iLike
        )
    }

    var onRemoteLikePressed = {
        iLikeState = iLikeState.copy(
            numberOfLikes = iLikeState.numberOfLikes + 1
        )
    }

    val context = LocalContext.current
    val imageBitmap: ImageBitmap? =
        if (conImagen)
            ImageBitmap.imageResource(context.resources, R.drawable.magdalenas)
        else
            null

    RecetasTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Receta(
                iLike = iLikeState,
                recipeName = "Magdalenas de la abuela",
                recipeDescription = "Fabulosas magdalenas con pepitas de chocolate y un suave sabor a naranja.",
                recipeChef = "Carlos Arguiñano",
                recipeFoto = imageBitmap,
                onILikePressed = onLocallyLikePressed
            )
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = onRemoteLikePressed) {
                Text(text = "Otro usuario pulsa Like")
            }
        }
    }
}
