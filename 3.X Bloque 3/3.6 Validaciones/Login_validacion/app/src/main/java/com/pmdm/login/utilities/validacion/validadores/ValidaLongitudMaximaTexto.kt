package com.pmdm.utilities.validacion.validadores

import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador

class ValidaLongitudMaximaTexto(
    val tamañoMaximo: Int,
    val mensajeError: String = "El texto debe ser inferior a ${tamañoMaximo}"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (texto.length <= tamañoMaximo) {
            Validacion(false)
        } else {
            Validacion(true, mensajeError)
        }
    }
}