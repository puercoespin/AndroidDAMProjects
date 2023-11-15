package com.dialogos.ui.features.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePickerDialog

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.dialogos.R


@Composable
fun DialogoTarea(
    onConfirButton: (String) -> Unit,
    onDismissRequest: () -> Unit,
    onFechaButton: () -> Unit
) {
    var texto by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismissRequest,
        text = {

            Column()
            {
                Text(text = "Introduce la nueva Tarea")
                OutlinedTextField(value = texto, onValueChange = { texto = it })
                TextButton(onClick = onFechaButton)
                {
                    Text("Añadir Fecha de tarea")
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirButton(texto)
                }
            ) {
                Text("Añadir tarea")
            }
        })

}