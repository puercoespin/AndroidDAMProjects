package com.xusa.tema0.holamundo.ui.features.pesos
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xusa.tema0.holamundo.ui.theme.MyApplicationTheme

@Composable

fun PesosScreen()
{
    Box{
        Row(modifier = Modifier.fillMaxSize())
        {
            Box(modifier = Modifier.background(Color.Blue).fillMaxHeight().weight(4f))
            Box(modifier = Modifier.background(Color.Red).fillMaxHeight().weight(6f))
            Box(modifier = Modifier.background(Color.Yellow).fillMaxHeight().weight(6f))
            Box(modifier = Modifier.background(Color.Green).fillMaxHeight().weight(4f))

        }
    }
}

@Preview
@Composable
fun PesosScreenText() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PesosScreen()
        }
    }

}