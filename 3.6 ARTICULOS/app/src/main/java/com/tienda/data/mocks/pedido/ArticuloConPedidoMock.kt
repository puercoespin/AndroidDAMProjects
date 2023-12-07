package com.pmdm.tienda.data.mocks.pedido

import com.pmdm.tienda.data.mocks.articulo.ArticuloMock




//ENTIDAD PARA CREAR LA RELACIÓN MUCHOS A MUCHOS ENTRE ARTICULOS Y PEDIDOS
data class ArticuloConPedidoMock (
    val articuloId: Int,
    val pedidoId: Long,
    val tamaño: Short,
    val cantidad:Int)