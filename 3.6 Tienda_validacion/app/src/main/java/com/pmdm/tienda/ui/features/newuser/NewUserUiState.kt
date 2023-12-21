package com.pmdm.tienda.ui.features.newuser

import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.datospersonales.ValidacionDatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionUiState
import com.pmdm.tienda.ui.features.newuser.direccion.ValidacionDireccionUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.ValidacionNewUserPasswordUiState

data class NewUserUiState(
    var datosPersonalesUiState: DatosPersonalesUiState = DatosPersonalesUiState(),
    var direccionUiState: DireccionUiState = DireccionUiState(),
    var newUserPasswordUiState: NewUserPasswordUiState = NewUserPasswordUiState(),

    var validadorDatosPersonalesUiState: ValidacionDatosPersonalesUiState = ValidacionDatosPersonalesUiState(),
    var validadorDireccionUiState: ValidacionDireccionUiState = ValidacionDireccionUiState(),
    var validadorNewUserPasswordUiState: ValidacionNewUserPasswordUiState = ValidacionNewUserPasswordUiState()

)