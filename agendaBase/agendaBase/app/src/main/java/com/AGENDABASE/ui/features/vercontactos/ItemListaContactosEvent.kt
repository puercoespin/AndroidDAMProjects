package com.pmdm.agenda.ui.features.vercontactos

import com.AGENDABASE.ui.features.vercontactos.ContactoUiState

sealed interface ItemListaContactosEvent {
    data class OnClickContacto(val contacto : ContactoUiState) : ItemListaContactosEvent
    object OnDeleteContacto : ItemListaContactosEvent
}