package com.pmdm.utilities.validacion.validadores

import android.util.Range
import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador


class ValidaNumeroEntero(
    val rango: Range<Int> = Range(0, Int.MAX_VALUE),
    val mensajeError: String = "Se espera un valor entero"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (texto.matches(Regex("[0-9]+"))
            && rango.contains(texto.toInt())
        ) {
            Validacion(false)
        } else {
            Validacion(true, mensajeError)
        }
    }
}