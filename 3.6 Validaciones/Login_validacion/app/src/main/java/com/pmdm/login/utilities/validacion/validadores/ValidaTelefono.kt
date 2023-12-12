package com.pmdm.agenda.utilities.validacion.validadores

import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.Validador

class ValidaTelefono(
    val mensajeError: String = "Teléfono no válido"
) : Validador {
    override fun valida(texto: String): Validacion {
        return if (Regex("^[0-9]{9,18}$").matches(texto)) {
            Validacion(false)
        } else {
            Validacion(true, mensajeError)
        }
    }
}