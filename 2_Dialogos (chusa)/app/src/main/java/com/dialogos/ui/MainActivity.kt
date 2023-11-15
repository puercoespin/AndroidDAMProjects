package com.dialogos.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dialogos.ui.features.TareasScreen
import com.dialogos.ui.theme.ProyectoBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var tarea by remember { mutableStateOf("Tarea uno\n\nTarea dos\n\nTarea tres\n\nTarea cuatro") }
                    var fecha by remember{ mutableStateOf("") }
                    TareasScreen(tarea) {
                        if(tarea.isNotEmpty())  tarea = "$tarea\n\n$it"
                    }
                }
            }
        }
    }
}



