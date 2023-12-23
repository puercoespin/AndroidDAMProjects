package com.pmdm.tienda.ui.features.newuser.direccion

sealed interface DireccionEvent
{
    data class CalleChanged(val calle:String): DireccionEvent
    data class CiudadChanged(val ciudad:String): DireccionEvent
    data class CodigoPostalChanged(val codigoPostal:String): DireccionEvent
    object OnClickSiguiente:DireccionEvent
}