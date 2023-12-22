package com.ejemplo_intents.ui.features.prueba_intents

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PruebaIntentsComposeViewModel:ViewModel() {
    var telefono by  mutableStateOf("")
    fun onSeleccionarContacto(telefono:String)
    {
        this.telefono=telefono
    }
}