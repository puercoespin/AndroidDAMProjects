package com.pmdm.agenda.ui.features.vercontactos

sealed interface ItemListaContactosEvent {
    data class OnClickContacto(val contacto : ContactoUiState) : ItemListaContactosEvent
    object OnDeleteContacto : ItemListaContactosEvent
}