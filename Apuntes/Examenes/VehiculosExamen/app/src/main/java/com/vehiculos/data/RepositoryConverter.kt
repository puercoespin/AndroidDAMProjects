package com.vehiculos.data

import com.vehiculos.data.mocks.CocheMock
import com.vehiculos.model.Coche
import com.vehiculos.ui.features.cochesFicha.FichaCocheUiState

fun Coche.toCocheMock(): CocheMock {
    return CocheMock(
        fabricante,
        modelo,
        año,
        precio,
        porcentajeDescuento,
        stock,
        descripcion
    )
}

fun CocheMock.toCoche(): Coche {
    return Coche(
        fabricante,
        modelo,
        año,
        precio,
        porcentajeDescuento,
        stock,
        descripcion
    )
}

fun Coche.toCocheUiState(): FichaCocheUiState = FichaCocheUiState(
    fabricante,
    modelo,
    año,
    precio,
    porcentajeDescuento,
    stock,
    descripcion
)

fun MutableList<Coche>.toCocheUiState() = this.map { it.toCocheUiState() }.toMutableList()
