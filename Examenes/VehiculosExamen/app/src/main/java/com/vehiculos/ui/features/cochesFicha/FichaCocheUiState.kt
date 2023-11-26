package com.vehiculos.ui.features.cochesFicha

import androidx.compose.ui.graphics.painter.Painter

data class FichaCocheUiState(
    var fabricante: String ="",
    var modelo: String ="",
    var año: Int = 0,
    var precio : Float = 0f,
    var porcentajeDescuento : Int = 0,
    var stock : Int = 0,
    var descripcion : String = ""
) {
}