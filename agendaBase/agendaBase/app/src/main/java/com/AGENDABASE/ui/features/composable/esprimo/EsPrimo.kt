package com.AGENDABASE.ui.features.composable.esprimo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlin.random.Random

@Composable
fun NumPrimos()
{
    var numGenerado by remember { mutableStateOf(0) }

    var esPrimo : MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button(onClick = { numGenerado = Random.nextInt(1,100+1) }) {
            Text(text = "Genera número")
        }

        Text(text = "El número generado es.. ${numGenerado}")

        Button(onClick = { esPrimo.value = comprobarPrimo() }) {
            Text(text = "Es primo?")
        }

        if(esPrimo.value == true)
        {
            Text(text = "El número es primo")
        }
        else
        {
            Text(text = "El número no es primo")
        }

    }
}

fun comprobarPrimo() : Boolean
{

    return true
}
