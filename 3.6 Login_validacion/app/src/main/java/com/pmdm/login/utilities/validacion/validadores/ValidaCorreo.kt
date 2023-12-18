package com.pmdm.utilities.validacion.validadores

import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador


class ValidaCorreo(
    val mensajeError: String = "Correo no válido"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})$").matches(texto)) {
            Validacion(false)
        } else {
            Validacion(true, mensajeError)
        }
    }
}