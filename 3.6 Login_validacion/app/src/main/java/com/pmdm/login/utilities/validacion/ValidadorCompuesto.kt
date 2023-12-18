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
            }
        }
        return Validacion(false)
    }
}
