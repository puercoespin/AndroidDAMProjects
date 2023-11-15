package com.xusa.tema0.holamundo.ui.features.conversor

import android.content.res.Resources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xusa.tema0.holamundo.ui.theme.MyApplicationTheme


@Preview(showBackground = true, name = "Conversor preview")
@Composable
fun ConversorScreen() {
    var textoKilometros by rememberSaveable{ mutableStateOf("") }
    val resultadoMillas by remember { derivedStateOf {
        if(textoKilometros.toFloatOrNull() == null) 0f else textoKilometros.toFloat()}}

    var textoKilogramos by rememberSaveable{ mutableStateOf("") }
    val resultadoLibras by remember { derivedStateOf {
        if(textoKilogramos.toFloatOrNull() == null) 0f else textoKilogramos.toFloat()}}

    var TextoLitros by rememberSaveable{ mutableStateOf("") }
    val resultadoGaleones by remember { derivedStateOf {
        if(TextoLitros.toFloatOrNull() == null) 0f else TextoLitros.toFloat()}}

    Column {
        KilometrosMillasInterf(textoKilometros,
            introducirCadena = {textoKilometros = it},
            resultadoMillas * 0.62f)
        KilogramosLibrasInterf(textoKilogramos,
            introducirCadena = {textoKilogramos = it},
            resultadoLibras * 2.20f)
        LitrosGalonesInterf(
            TextoLitros, introducirCadena = {TextoLitros = it},
            resultadoGaleones * 0.26f)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KilometrosMillasInterf(
    textoUno : String,
    introducirCadena : (String) -> Unit,
    resultado : Float
)
{
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            text = "Kilometros"
        )
        TextField(
            modifier = Modifier.weight(6f),
            value = textoUno, onValueChange = introducirCadena,

        )
        TextField(
            modifier = Modifier.weight(6f),
            value = resultado.toString(), onValueChange = {},
            enabled = false
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            text = "Millas"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KilogramosLibrasInterf(
    textoUno : String,
    introducirCadena : (String) -> Unit,
    resultado : Float
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            text = "kilogramos"
        )
        TextField(
            modifier = Modifier.weight(6f),
            value = textoUno, onValueChange = introducirCadena
        )
        TextField(
            modifier = Modifier.weight(6f),
            value = resultado.toString(), onValueChange = {},
            enabled = false
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            text = "libras"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LitrosGalonesInterf(
    textoUno : String,
    introducirCadena : (String) -> Unit,
    resultado : Float
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            text = "Litros"
        )
        TextField(
            modifier = Modifier.weight(6f),
            value = textoUno, onValueChange = introducirCadena
        )
        TextField(
            modifier = Modifier.weight(6f),
            value = resultado.toString(), onValueChange = {},
            enabled = false
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f),
            text = "Galeones"
        )
    }
}

