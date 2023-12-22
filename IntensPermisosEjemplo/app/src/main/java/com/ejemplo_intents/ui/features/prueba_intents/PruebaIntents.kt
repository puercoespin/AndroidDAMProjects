package com.ejemplo_intents.ui.features.prueba_intents

import android.content.Intent
import android.provider.ContactsContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity

@Composable
fun PruebaIntentsScreen(
    telefono: String,
    onSeleccionContacto: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val contexto = LocalContext.current
        Button(
            onClick = {
                val intento=Intent(Intent.ACTION_MAIN).also {
                    it.`package`= "com.android.chrome"

                }
                startActivity(contexto,intento,null)

            }) {
            Text(text="Abrir con Intent Explicito")
        }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = ContactsContract.Contacts.CONTENT_TYPE
            }
            startActivity(contexto, intent, null)
        }) {
            Text("Abrir contactos")
        }
        Button(onClick = onSeleccionContacto) {
            Text("Seleccionar contacto")
        }
        Text(telefono)
    }
}
