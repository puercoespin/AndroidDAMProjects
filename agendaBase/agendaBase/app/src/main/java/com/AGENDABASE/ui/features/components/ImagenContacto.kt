package com.AGENDABASE.ui.features.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face2
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.AGENDABASE.R
import com.AGENDABASE.ui.theme.ProyectoBaseTheme


@Composable
fun ImagenContacto(
    modifier: Modifier = Modifier,
    foto : ImageBitmap?,
    anchoBorde : Dp = 4.dp,
)
{
    var painterFoto : Painter = if(foto!=null){remember(foto){ BitmapPainter(foto)}}
                                else{rememberVectorPainter(image = Icons.Filled.Face2)}

    Image(
        painterFoto,
        contentDescription="Imagen contacto",

        modifier = Modifier
            .clip(CircleShape)
            .aspectRatio(ratio = 1f)
            .background(MaterialTheme.colorScheme.surface)
            .border(
                width = anchoBorde,
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = CircleShape
            ),
        contentScale = ContentScale.Crop,
        )

}

@Preview
@Composable
fun ImagenContactoPreviewSinFoto()
{
    ProyectoBaseTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .height(200.dp)
                .width(300.dp)
        )
        {
            ImagenContacto(
                modifier = Modifier
                    .fillMaxHeight(),
                foto = null
            )
        }
    }
}


@Composable
fun ImagenContactoPreviewConFotoYFondo()
{
    ProyectoBaseTheme {
        Box(
           modifier = Modifier
               .background(MaterialTheme.colorScheme.primary)
               .width(300.dp)
               .height(200.dp)
               .fillMaxSize()
        )
        {
            Image(
                modifier = Modifier
                    .matchParentSize(),
                painter = if(isSystemInDarkTheme()){painterResource(id = R.drawable.bg_dark)}else{painterResource(id = R.drawable.bg_light)},
                contentDescription = "Fondo de la imágen",
                contentScale = ContentScale.FillBounds
            )
            ImagenContacto(
                modifier = Modifier,
                foto = ImageBitmap.imageResource(R.drawable.foto_prueba)
            )
        }
    }
}


@Preview
@Composable
fun ImagenContactoPreviewConFotoYFondoClaro() {
    ImagenContactoPreviewConFotoYFondo()
}

@Preview
@Composable
fun ImagenContactoPreviewConFotoYFondoOscuro() {
    ImagenContactoPreviewConFotoYFondo()
}