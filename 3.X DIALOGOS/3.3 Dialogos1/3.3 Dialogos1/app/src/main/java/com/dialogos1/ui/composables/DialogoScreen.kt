package com.dialogos1.ui.composables

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.dialogos1.ui.theme.ProyectoBaseTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun TextoTareas(tareas: List<String>) {

    for (tarea in tareas) {
        Text(
            text = tarea
        )
    }
}

@Composable
fun BotonFlotante(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
        text = { Text(text = "Añadir tarea") },
    )
}

@Composable
fun DialogoAñadirTarea(
    onAceptarDialogoTarea: () -> Unit,
    onCalcelaDialogoTarea: () -> Unit,
    introducirCadena: (String) -> Unit,
    onAñadirFecha: () -> Unit,
    texto: String
) {
    AlertDialog(
        icon = {
            Icon(
                Icons.Filled.QuestionAnswer,
                contentDescription = "Pregunta"
            )
        },
        text = {
            Column {
                Text(text = "Introduce una nueva tarea")
                TextField(value = texto, onValueChange = introducirCadena)
                Text(
                    modifier = Modifier
                        .clickable(enabled = true, onClick = onAñadirFecha),
                    text = "Seleccionar fecha"
                )
            }
        },

        onDismissRequest = onCalcelaDialogoTarea,
        confirmButton = {
            TextButton(onClick = {
                onAceptarDialogoTarea()
                onCalcelaDialogoTarea()
            }) {
                Text("Aceptar")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogoFecha(
    datePickerState: DatePickerState,
    onCancelButton: () -> Unit,
    onAceptarButton: () -> Unit
) {
    //   val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = { onCancelButton() },
        confirmButton = {
            TextButton(onClick = { onAceptarButton();onCancelButton() }) {
                Text("Ok")
            }
        },
        dismissButton = {
            TextButton(onClick = { onCancelButton() }) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TareaScreen() {

    var dialogoBaseFuera by rememberSaveable { mutableStateOf(false) }
    var dialogoFechaFuera by rememberSaveable { mutableStateOf(false) }

    var textoTextField by rememberSaveable { mutableStateOf("") }
    var fechaSeleccionada by rememberSaveable { mutableStateOf("") }

    var tareas = remember { mutableListOf("Tareas:") }

    var datePickerState: DatePickerState = rememberDatePickerState()



    ProyectoBaseTheme {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextoTareas(tareas)
            BotonFlotante {
                dialogoBaseFuera = true
                textoTextField = ""
                fechaSeleccionada = ""
            }

            if (dialogoBaseFuera) {
                DialogoAñadirTarea(
                    onAceptarDialogoTarea = { tareas.add("$textoTextField $fechaSeleccionada") },
                    onCalcelaDialogoTarea = { dialogoBaseFuera = false },
                    introducirCadena = { textoTextField = it },
                    onAñadirFecha = { dialogoFechaFuera = true },
                    textoTextField
                )
            }

            if (dialogoFechaFuera) {
                DialogoFecha(
                    datePickerState = datePickerState,
                    onAceptarButton = {
                        if (datePickerState.selectedDateMillis != null) {
                            val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy")
                            val calendar = Calendar.getInstance()
                            calendar.timeInMillis = datePickerState.selectedDateMillis!!
                            val fechaString = formatter.format(calendar.time)
                            fechaSeleccionada = fechaString
                        }
                    },
                    onCancelButton = { dialogoFechaFuera = false }
                )
            }

        }
    }

}