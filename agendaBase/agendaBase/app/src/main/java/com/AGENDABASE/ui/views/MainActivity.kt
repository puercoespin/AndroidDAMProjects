package com.AGENDABASE.ui.views
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.AGENDABASE.ui.features.vercontactos.ListaContactosScreen
import com.AGENDABASE.ui.features.vercontactos.ListaContactosViewModel
import com.AGENDABASE.ui.theme.ProyectoBaseTheme
import com.pmdm.agenda.ui.features.vercontactos.ItemListaContactosEvent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm : ListaContactosViewModel by viewModels()
        setContent {
            ProyectoBaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaContactosScreen(
                        contactosState = vm.listaContactosState,
                        contactoSeleccionadoState = vm.contatoSleccionadoState,
                        onContactoClicked = { c ->
                            vm.onItemListaContatoEvent(
                                ItemListaContactosEvent.OnClickContacto(c))
                        },
                        onDeleteClicked = {
                            vm.onItemListaContatoEvent(
                                ItemListaContactosEvent.OnDeleteContacto)
                        }
                    )
                }
            }
        }
    }
}