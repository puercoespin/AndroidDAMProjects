package com.vehiculos.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vehiculos.ui.features.cochesFicha.CochesEvent
import com.vehiculos.ui.features.cochesFicha.FichaCocheUiState
import com.vehiculos.ui.features.reserva.ReservaUiState


@Composable
fun ReservaDialogue(
    reservaUiState: ReservaUiState,
    cocheUiState: FichaCocheUiState,
    onCochesEvent: (CochesEvent) -> Unit
) {

    AlertDialog(
        icon = {
            Icon(
                Icons.Filled.QuestionAnswer,
                contentDescription = "Pregunta"
            )
        },
        text = {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(text = "Datos de contacto")
                TextField(
                    value = reservaUiState.nombre,
                    onValueChange = {onCochesEvent(CochesEvent.onReservaNombreChanged(it))},
                    placeholder = { Text(text = "Nombre")}
                )
                TextField(
                    value = reservaUiState.telefono,
                    onValueChange = {onCochesEvent(CochesEvent.onReservaTelChanged(it))},
                    placeholder = { Text(text = "Telefono")}
                )

            }
        },

        onDismissRequest = {onCochesEvent(CochesEvent.onReservarClick)},//onCalcelaDialogoTarea,
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