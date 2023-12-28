package com.pmdm.utilities.validacion

class ValidadorCompuesto(validador: Validador) : Validador {
    private val validadores = mutableListOf(validador)
    fun add(validador: Validador): ValidadorCompuesto {
        validadores.add(validador)
        return this
    }

    override fun valida(texto: String): Validacion {
        validadores.forEach {
            val resultado = it.valida(texto)
            if (resultado.hayError) {
                return resultado
                // si hay un solo error, devolverá true el valida de la interfaz Validador de la validación correspondiente en la lista
            }
        }
        return Validacion(false)
    }
}
