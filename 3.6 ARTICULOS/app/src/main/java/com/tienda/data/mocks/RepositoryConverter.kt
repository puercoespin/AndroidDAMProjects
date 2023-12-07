package com.pmdm.lista_articulos.data.mocks

import com.pmdm.tienda.data.mocks.articulo.ArticuloMock
import com.pmdm.tienda.data.mocks.pedido.ArticuloConPedidoMock
import com.pmdm.tienda.models.Articulo
import com.pmdm.tienda.models.ArticuloDePedido

fun ArticuloMock.toArticulo(): Articulo =
    Articulo(this.id, this.url, this.precio, this.descripcion)

fun MutableList<ArticuloMock>.toArticulos(): List<Articulo> =
    this.map { it.toArticulo() }

fun Articulo.toArticuloMock(): ArticuloMock =
    ArticuloMock(this.id, this.url, this.precio, this.descripcion)





//mio
