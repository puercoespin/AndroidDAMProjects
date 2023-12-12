package com.pmdm.utilities.validacion.validadores

import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador

class ValidaLongitudMinimaTexto(
    val tamañoMinimo: Int,
    val mensajeError: String = "El texto debe mayor o igual a ${tamañoMinimo}"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (texto.length >= tamañoMinimo) {
            Validacion(false)
        } else {
            Validacion(true, mensajeError)
        }
    }
}
