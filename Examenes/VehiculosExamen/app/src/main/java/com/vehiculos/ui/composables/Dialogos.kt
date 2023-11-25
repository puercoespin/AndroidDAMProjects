package com.vehiculos.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.vehiculos.ui.features.reserva.ReservaUiState


@Composable
fun ReservaDialogue(
    reservaUiState: ReservaUiState,
) {
    var cadenaNombre by remember { mutableStateOf("") }
    var cadenaTelefono by remember { mutableStateOf("") }
    AlertDialog(
        icon = {
            Icon(
                Icons.Filled.QuestionAnswer,
                contentDescription = "Pregunta"
            )
        },
        text = {
            Column {
                Text(text = "Datos de contacto")
                TextField(value = cadenaNombre, onValueChange = {cadenaNombre=it})
                TextField(value = cadenaTelefono, onValueChange = {cadenaTelefono=it})

            }
        },

        onDismissRequest = {},//onCalcelaDialogoTarea,
        confirmButton = {
            TextButton(onClick = {
                reservaUiState.mostrarReserva
                {}//onAceptarDialogoTarea()
                {}//onCalcelaDialogoTarea()
            }) {
                Text("Aceptar")
            }
        }
    )
}