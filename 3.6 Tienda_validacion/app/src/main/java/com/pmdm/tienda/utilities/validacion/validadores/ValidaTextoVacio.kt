package com.pmdm.utilities.validacion.validadores

import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador


class ValidaTextoVacio(
    val mensajeError: String = "El campo no puede estar vacío"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (texto.isEmpty()) {
            Validacion(true, mensajeError)
        } else {
            Validacion(false)
        }
    }
}
