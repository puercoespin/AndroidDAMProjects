package com.pmdm.tienda.ui.features.login

import com.pmdm.utilities.validacion.Validacion

data class ValidacionLoginUiState(
    val validacionLogin: Validacion = Validacion(false),
    val validacionPassword: Validacion = Validacion(false),
    val validacionUsuario: Validacion = Validacion(false)
)