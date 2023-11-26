package com.vehiculos.ui.features.cochesFicha

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.vehiculos.data.CocheRepository
import com.vehiculos.data.toCocheUiState
import com.vehiculos.ui.features.reserva.ReservaUiState

class CochesViewModel : ViewModel() {
    val cochesRepository : CocheRepository = CocheRepository()

    var cocheUiState by mutableStateOf(loadCoches())

    var reservaUiState by mutableStateOf(ReservaUiState())

    fun onCochesEvent(cochesEvent: CochesEvent)
    {
        when(cochesEvent)
        {
            is CochesEvent.onReservarClick -> {

                reservaUiState = reservaUiState.copy(mostrarReserva = !reservaUiState.mostrarReserva)

            }
            is CochesEvent.onReservaNombreChanged ->
            {
                reservaUiState = reservaUiState.copy(nombre = cochesEvent.cadena)
            }
            is CochesEvent.onReservaTelChanged ->
            {
                reservaUiState = reservaUiState.copy(telefono = cochesEvent.cadena)
            }
        }
    }


    fun loadCoches() = cochesRepository.get().toCocheUiState().toMutableStateList()



}