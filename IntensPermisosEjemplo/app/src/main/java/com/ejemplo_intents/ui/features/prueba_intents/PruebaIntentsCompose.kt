package com.ejemplo_intents.ui.features.prueba_intents

import android.provider.ContactsContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.pmdm.agenda.utilities.device.RegistroSelectorContactosConGetContent



@Composable
fun PruebaIntentsComposeScreen(
    telefono:String,
    onSeleccionContacto:(String)->Unit
) {

    val selectorDeContacto =  RegistroSelectorContactosConGetContent(
        ActivityResultContracts.PickContact().apply {
            ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE }, onSeleccionContacto
    )

 /*   val selectorDeContacto = RegistroSelectorContactosConGetContent(
        ActivityResultContracts.PickContact()/*.apply {
            this.createIntent(LocalContext.current,null).apply { type=ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE}

        }*/,
        onSeleccionContacto
    )*/
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val contexto = LocalContext.current

        Button(onClick = {selectorDeContacto.launch()}) {
            Text("Seleccionar contacto")
        }
        Text(telefono)
    }
}
