package com.pmdm.login.ui.features.login

import com.pmdm.login.utilities.validacion.Validacion

data class ValidadorLoginUiState(
    val validacionLogin: Validacion = Validacion(false),
    val validacionPassword: Validacion = Validacion(false),
    val validacionUsuario: Validacion = Validacion(false)
)