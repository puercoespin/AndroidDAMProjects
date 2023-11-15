package com.dialogos.ui.features.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogo(onDismissButton: () -> Unit, onConfirmButton: (String) -> Unit) {
     val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismissButton,
        confirmButton = {
            TextButton(onClick = {
                if(datePickerState.selectedDateMillis!=null) {
                    val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy")
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = datePickerState.selectedDateMillis!!
                    onConfirmButton(formatter.format(calendar.time))
                }
            }) {
                Text("Ok")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissButton) {
                Text("Cancel")
            }
        }
    ) {
          DatePicker(state = datePickerState)
    }
}