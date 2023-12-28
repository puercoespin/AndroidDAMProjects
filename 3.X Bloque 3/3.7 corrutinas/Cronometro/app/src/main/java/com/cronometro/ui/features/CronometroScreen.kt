package com.cronometro.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.cronometro.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun CronometroScreen() {
    var segundos by remember { mutableIntStateOf(0) }
    var cadena by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    var activa by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center, Alignment.CenterHorizontally
    ) {
        Text(text = cadena, Modifier.padding(100.dp))
        Row(
        ) {
            ExtendedFloatingActionButton(
                onClick = {
                    if (!activa) {
                        activa = true

                        scope.launch {
                            while (activa) {
                                delay(1000)
                                if (activa) {
                                    segundos += 1
                                }
                                cadena = formateaSegundos(segundos)
                            }
                        }
                    }
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.start),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                },
                text = { Text(text = "Start") },
            )
            ExtendedFloatingActionButton(
                onClick = { if(activa){activa=false} },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.stop),
                        contentDescription = "stop png",
                        modifier = Modifier.size(24.dp)
                    )
                },
                text = { Text(text = "Stop") },
            )
            ExtendedFloatingActionButton(
                onClick = { segundos = 0 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.reset),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                },
                text = { Text(text = "Reset") },
            )
        }
    }
}

fun formateaSegundos(segundosEntrada: Int): String {
    val hora = Integer.toString(segundosEntrada / 3600)
    val minutos = Integer.toString(segundosEntrada % 3600 / 60)
    val segundos = Integer.toString(segundosEntrada % 3600 % 60)
    var stringBuilder = StringBuilder()
    stringBuilder.append((if (hora.toInt() < 10) "0$hora" else hora).toString())
    stringBuilder.append(":")
    stringBuilder.append((if (minutos.toInt() < 10) "0$minutos" else minutos).toString())
    stringBuilder.append(":")
    stringBuilder.append((if (segundos.toInt() < 10) "0$segundos" else segundos).toString())
    return stringBuilder.toString()
}