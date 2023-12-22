package com.ejemplo_intents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ejemplo_intents.ui.features.prueba_intents.PruebaIntentsComposeViewModel
import com.ejemplo_intents.ui.features.prueba_intents.PruebaIntentsScreen
import com.ejemplo_intents.ui.theme.ProyectoBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel:PruebaIntentsComposeViewModel by viewModels()
        super.onCreate(savedInstanceState)
        var telefono by  mutableStateOf("")
        val launcherAbrirContactos: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val contactUri: Uri? = result.data?.data

                    val projection: Array<String> =
                        arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    if (contactUri != null) {
                        contentResolver.query(contactUri, projection, null, null, null)
                            .use { cursor ->
                                if (cursor != null && cursor.moveToFirst()) {
                                    val numberIndex =
                                        cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                                    val number = cursor.getString(numberIndex)
                                   telefono = number
                                }
                            }
                    }
                }
            }
        setContent {
            ProyectoBaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  PruebaIntentsScreen(telefono){
                        val intent = Intent(Intent.ACTION_PICK).apply {
                            type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
                        }
                        launcherAbrirContactos.launch(intent)
                    }
                /*  PruebaIntentsComposeScreen(telefono = viewModel.telefono,
                        onSeleccionContacto = viewModel::onSeleccionarContacto)
              */  }
            }
        }
    }
}
