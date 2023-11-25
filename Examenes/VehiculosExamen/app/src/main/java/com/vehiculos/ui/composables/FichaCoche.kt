package com.vehiculos.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.Grade
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.login.ui.composables.ImageCommonTest
import com.vehiculos.R
import com.vehiculos.ui.features.cochesFicha.CochesEvent
import com.vehiculos.ui.features.cochesFicha.FichaCocheUiState


@Composable
fun BotonFlotante(onClick: () -> Unit, texto: String) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Grade, "Extended floating action button.") },
        text = { Text(text = texto) },
    )
}

@Composable
fun Precio(
    precio: Float,
    porcentajeDescuento: Int,

    ) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(90.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            val precioConDescuento = precio - precio * porcentajeDescuento / 100

            Text(
                text = "$precioConDescuento €",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            if (porcentajeDescuento > 0) {
                Text(
                    text = "antes ${precio} €",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        if (porcentajeDescuento > 0) {
            Box(
                modifier = Modifier.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = MaterialTheme.shapes.small
                ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "${porcentajeDescuento}%",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}


@Composable
fun CardCoche(
    coche: FichaCocheUiState,
    onCochesEvent: (CochesEvent) -> Unit
) {
    Card(
        modifier = Modifier.wrapContentSize()
    )
    {
        Column {
            Surface(
                modifier = Modifier.clip(CardDefaults.shape),
                color = MaterialTheme.colorScheme.primary
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Foto de un coche",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                )

                Column {
                    Text(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        text = coche.fabricante,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        text = coche.modelo,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                text = coche.descripcion,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.size(12.dp))

            Precio(precio = coche.precio, porcentajeDescuento = coche.porcentajeDescuento)

            Spacer(modifier = Modifier.size(12.dp))

            HorizontalDivider(
                modifier = Modifier
                    .padding(12.dp)
            )
            BotonFlotante(onClick = {onCochesEvent}, texto = "Reservar")

        }
    }
}

@Preview
@Composable
fun cochePreview() {

    var pruebaCoche = FichaCocheUiState(
        "fabricante1",
        "modelo1",
        1993,
        10000f,
        15,
        3, "descripcion"
    )

    Column {
        CardCoche(coche = pruebaCoche, onCochesEvent = {})
    }
}