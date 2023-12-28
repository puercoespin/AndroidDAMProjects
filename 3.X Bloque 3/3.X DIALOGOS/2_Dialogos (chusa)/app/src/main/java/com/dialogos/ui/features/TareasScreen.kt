package com.dialogos.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dialogos.ui.features.components.DatePickerDialogo
import com.dialogos.ui.features.components.DialogoTarea
import com.dialogos.ui.theme.ProyectoBaseTheme

@Composable
fun TareasScreen(
    tarea: String,
    onAñadirTarea: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onSecondaryContainer),
        contentAlignment = Alignment.Center
    )
    {
        var verDialogoTarea by remember { mutableStateOf(false) }
        var verDialogoFecha by remember { mutableStateOf(false) }
        var fecha by remember{ mutableStateOf("") }
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(50.dp),
            text = tarea,
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyLarge
        )
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(50.dp),
            onClick = { verDialogoTarea = true }
        )
        {
            Text(modifier = Modifier.padding(15.dp), text = "Añadir Tarea")
        }

        if (verDialogoTarea) DialogoTarea(onConfirButton = {
            if(it.isNotEmpty()) {
                if (fecha != "") {
                    onAñadirTarea("$it el día $fecha")
                    fecha = ""
                } else onAñadirTarea(it)
            }
            verDialogoTarea = false
        }, onDismissRequest = { verDialogoTarea = false }, onFechaButton = {verDialogoFecha=true})

        if(verDialogoFecha) DatePickerDialogo(onDismissButton ={verDialogoFecha=false}, onConfirmButton = {
            fecha=it
            verDialogoFecha=false
        })
    }
}

@Preview(showBackground = true)
@Composable
fun TareaText() {
    ProyectoBaseTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var tarea by remember { mutableStateOf("Tarea uno\n\nTarea dos\n\nTarea tres\n\nTarea cuatro") }
        
            TareasScreen(tarea) {
                if(tarea.isNotEmpty())  tarea = "$tarea\n\n$it"
            }
        }
    }

}