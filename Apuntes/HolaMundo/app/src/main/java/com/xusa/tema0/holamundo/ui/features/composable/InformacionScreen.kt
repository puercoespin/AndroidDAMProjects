package com.xusa.tema0.holamundo.ui.features.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xusa.tema0.holamundo.ui.theme.MyApplicationTheme


@Composable
fun Cabecera2()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium
            )
            .padding(12.dp)
    ) {
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary,
            text = "hola mundillo"
        )
    }
}

@Composable
fun Secciones()
{
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
                .background(Color.White, shape = MaterialTheme.shapes.medium)
        )
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
                .background(Color.White, shape = MaterialTheme.shapes.medium)
        )

    }
}

@Preview
@Composable
fun InformacionScreen()
{
    MyApplicationTheme {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Cabecera2()
            Secciones()
        }
    }
}