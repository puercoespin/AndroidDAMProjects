package com.pmdm.tienda.ui.features.newuser

import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.datospersonales.ValidacionDatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionUiState
import com.pmdm.tienda.ui.features.newuser.direccion.ValidacionDireccionUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.ValidacionNewUserPasswordUiState

data class NewUserUiState(
    var datosPersonalesUiState: DatosPersonalesUiState,
    var direccionUiState: DireccionUiState,
    var newUserPasswordUiState: NewUserPasswordUiState,

    var validacionDatosPersonalesUiState: ValidacionDatosPersonalesUiState,
    var validacionDireccionUiState: ValidacionDireccionUiState,
    var validacionNewUserPasswordUiState: ValidacionNewUserPasswordUiState

)