package com.xusa.tema0.holamundo.ui.features.saludo

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SaludaScreen(  nombreState: String,
                   onClickBorrar: () -> Unit,
                   onCambioNombre: (String) -> Unit
                   )
{
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Pasamos el estado y manejadores necesarios a los componentes
        IntroduceNombre(
            nombreState = nombreState,
            onCambioNombre = onCambioNombre
        )
        Saluda(
            nombreState = nombreState,
            onClickBorrar = onClickBorrar
        )
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Saluda(
    nombreState: String,
    onClickBorrar: () -> Unit
) {
    FlowRow(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(12.dp),
            text = "Hola ${nombreState}"
        )
        // Elevamos el evento borrar
        Button(onClick = onClickBorrar) { Text(text = "Borrar") }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroduceNombre(
    nombreState: String,
    onCambioNombre: (String) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.padding(12.dp),
            text = "Nombre:"
        )
        TextField(
            value = nombreState,
            // Elevamos el evento cambio en Nombre
            onValueChange = onCambioNombre
        )
    }
}


@Preview
@Composable
fun SaludoScreenText()
{
    var nombreState by remember { mutableStateOf("") }
  //  val onCambioNombre = { nombre: String -> nombreState = nombre }
 //   val onClickBorrar = { nombreState = "" }
 //   SaludaScreen(nombreState,onCambioNombre = onCambioNombre, onClickBorrar = onClickBorrar)
    SaludaScreen(nombreState,onCambioNombre = {
                  nombreState=it
    }, onClickBorrar = {
        nombreState=""
    })
}