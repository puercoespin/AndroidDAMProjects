package com.AGENDABASE.ui.features.vercontactos

import androidx.compose.ui.graphics.ImageBitmap
import java.time.Instant

data class ContactoUiState(
    val id: Int = Instant.now().epochSecond.toInt(),
    val nombre: String = "",
    val apellidos: String = "",
    val foto: ImageBitmap? = null,
    val correo: String = "",
    val telefono: String = "",
    val categorias : CatergoriaUiState = CatergoriaUiState(),
)