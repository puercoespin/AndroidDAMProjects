package com.vehiculos.ui.features.cochesFicha

sealed interface CochesEvent{

    object onReservarClick : CochesEvent

    data class onReservaNombreChanged(var cadena : String):CochesEvent

    data class onReservaTelChanged(var cadena : String):CochesEvent

}