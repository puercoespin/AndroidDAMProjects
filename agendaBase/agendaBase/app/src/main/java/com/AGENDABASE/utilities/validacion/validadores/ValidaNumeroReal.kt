package com.pmdm.agenda.utilities.validacion.validadores

import android.util.Range
import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador

class ValidaNumeroReal(
    val rango: Range<Double> = Range(0.0, Double.MAX_VALUE),
    val mensajeError: String = "Se espera un valor real"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (texto.matches(Regex("^[0-9]+(\\.[0-9]+)?$"))
            && rango.contains(texto.toDouble())
        ) {
            Validacion(false)
        } else {
            Validacion(true, mensajeError)
        }
    }
}