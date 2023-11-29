package com.AGENDABASE.ui.features.vercontactos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.AGENDABASE.R
import com.AGENDABASE.ui.features.components.ImagenContacto
import com.AGENDABASE.ui.theme.ProyectoBaseTheme

@Composable
fun Categorias(categoriasState: CatergoriaUiState)
{
    Row {

        if(categoriasState.amigos)
        {
            Icon(painter = rememberVectorPainter(categoriasState.amigosIcon) , contentDescription = "")
        }
        if(categoriasState.familia)
        {
            Icon(painter = rememberVectorPainter(categoriasState.familiaIcon), contentDescription = "")
        }

    }
}

@Composable
fun ContactoInfo(categoriasState: CatergoriaUiState)
{
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Contacto titulo",
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "Contacto info1",
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.secondary
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Contacto info2",
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Categorias(categoriasState)
        }

    }
}

@Preview
@Composable
fun ContactoCardPreview()
{
    var categoriasState =  CatergoriaUiState(familia = true, amigos = true)

    ProyectoBaseTheme {
        Row{

            ContactoInfo(categoriasState)

        }
    }
}