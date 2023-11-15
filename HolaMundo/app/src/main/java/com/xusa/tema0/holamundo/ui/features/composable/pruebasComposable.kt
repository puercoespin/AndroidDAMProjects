package com.xusa.tema0.holamundo.ui.features.composable

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xusa.tema0.holamundo.ui.theme.MyApplicationTheme

@Preview(showBackground = true, name = "CabeceraPreview")
@Composable
fun Cabecera() {
    val contexto= LocalContext.current
    MyApplicationTheme {
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
                modifier = Modifier.clickable(enabled = true) {
                  Toast.makeText(contexto,"hola mundo",Toast.LENGTH_LONG).show()
                },
                text = "IES Doctor Balmis",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
                // color = Color.Red
            )
            Text("Módulo PMDM 2º DAM")
        }
    }
}