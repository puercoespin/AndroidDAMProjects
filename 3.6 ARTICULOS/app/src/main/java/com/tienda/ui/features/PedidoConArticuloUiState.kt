package com.pmdm.lista_articulos.ui.features.pedidos

import com.pmdm.tienda.data.mocks.pedido.ArticuloConPedidoMock
import com.pmdm.tienda.models.ArticuloDePedido
import com.pmdm.tienda.models.Pedido

data class ArticuloConPedido(
    val url:String,
    val tamaño: Short,
    val precio: Float,
    val cantidad: Int
)

data class PedidoConArticuloUiState(
    val articulos:List<ArticuloConPedido>,
    val pedidoId: Long,
    val total: Float,
    val fecha: Long
)
enum class TipoTalla(val tipo: String) {
    PEQUEÑA("S"), MEDIANA("M"), GRANDE("L"), XGRANDE("XL"), NOTALLA("Not")
}


