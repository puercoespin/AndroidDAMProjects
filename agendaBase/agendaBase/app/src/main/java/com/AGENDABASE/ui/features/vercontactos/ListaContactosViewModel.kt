package com.AGENDABASE.ui.features.vercontactos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.AGENDABASE.data.ContactoRepository
import com.pmdm.agenda.ui.features.vercontactos.ContactoUiState
import com.pmdm.agenda.ui.features.vercontactos.ItemListaContactosEvent
import com.pmdm.agenda.ui.features.vercontactos.toContactoUiState

class ListaContactosViewModel : ViewModel() {

    // Creamos un repositorio de contactos. Mejor inyectarlo con Hilt
    private val contactoRepository = ContactoRepository();
    // Estado que nos permitirá gestionar el contacto actualmente
    // seleccionado, valdrá null si no hay ninguno
    var contatoSleccionadoState: ContactoUiState? by mutableStateOf(null)
        private set
    // Creamos un estado con la lista de contactos y llamamos a una
    // función privada que se encargará del mapeo entre el Modelo y el UiState
    private var _listaContactosState by mutableStateOf(getContactos())
    // El getter solo nos permite acceder al estado pero no modificarlo
    val listaContactosState: List<ContactoUiState>
        get() = _listaContactosState
    // Función privada que nos permite obtener la lista de contactos
    // mapeando entre el Modelo y el UiState
    private fun getContactos(): MutableList<ContactoUiState> = contactoRepository.get()
        .map { it.toContactoUiState() }.toMutableList()
    // Método que nos permite gestionar los eventos que se produzcan en
    // nuestro caso la selección de un contacto y su eliminación
    fun onItemListaContatoEvent(e: ItemListaContactosEvent) {
        when (e) {
            is ItemListaContactosEvent.OnClickContacto -> {
                contatoSleccionadoState =
                    if (contatoSleccionadoState?.id != e.contacto.id) e.contacto else null
            }
            is ItemListaContactosEvent.OnDeleteContacto -> {
                contactoRepository.delete(contatoSleccionadoState!!.id)
                // Una vez hemos borrado deberemos actualizar la lista de
                // contactos para que se actualice el estado de la misma
                _listaContactosState = getContactos()
            }
        }
    }

}