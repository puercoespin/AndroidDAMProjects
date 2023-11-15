package com.xusa.tema0.holamundo.ui.features.contador

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.xusa.tema0.holamundo.ui.theme.MyApplicationTheme

@Composable
fun Contador(
    cuenta:Int,
    onIncrementar:()->Unit
) {
    // cuenta es un MutableState<Int> con valor inicial 0
    var verState by remember { mutableStateOf(false) }

    // Para acceder al valor de cuenta usamos la propiedad value
    Button(onClick = onIncrementar/*{
        onIncrementar
        verState=!verState
    }*/){
        Text("Llevas ${cuenta} Clicks")
    }
    if(verState)   Text("Hola")
}

@Preview(showBackground = true)
@Composable
fun ContadorText() {
    MyApplicationTheme {
        var cuentaState by remember { mutableStateOf(0) }
        val onIncrement:()->Unit={cuentaState++}
        Contador(cuenta=cuentaState, onIncrementar = onIncrement)
    }
}