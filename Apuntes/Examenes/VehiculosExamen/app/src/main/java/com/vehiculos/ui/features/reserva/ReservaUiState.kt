package com.vehiculos.ui.features.reserva

import com.vehiculos.ui.features.cochesFicha.FichaCocheUiState

data class ReservaUiState(
    var nombre : String = "",
    var telefono : String = "",
    var mostrarReserva : Boolean = false,
    var coche : FichaCocheUiState = FichaCocheUiState()
) {
}