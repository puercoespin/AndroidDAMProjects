package com.pmdm.utilities.validacion

class ValidacionCompuesta {
    private val validaciones = mutableListOf<Validacion>()
    fun add(validacion: Validacion): ValidacionCompuesta {
        validaciones.add(validacion)
        return this
    }

    val hayError: Boolean
        get() {
            validaciones.forEach {
                if (it.hayError) {
                    return true
                }
            }
            return false
        }
}