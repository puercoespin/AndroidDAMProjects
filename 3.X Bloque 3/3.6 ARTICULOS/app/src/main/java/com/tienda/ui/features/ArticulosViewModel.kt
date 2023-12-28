package com.tienda.ui.features

import androidx.lifecycle.ViewModel
import com.pmdm.lista_articulos.ui.features.pedidos.ArticuloConPedido
import com.pmdm.lista_articulos.ui.features.pedidos.PedidoConArticuloUiState
import com.pmdm.tienda.data.PedidoRepository
import com.pmdm.tienda.data.mocks.ArticuloRepository
import com.pmdm.tienda.models.ArticuloDePedido
import com.pmdm.tienda.models.Pedido

class ArticulosViewModel : ViewModel() {

    val articuloRepository : ArticuloRepository = ArticuloRepository()
    val pedidoRepository : PedidoRepository = PedidoRepository()

    /*
        Como sólo necesitamos el pedido 1, lo hacemos directamente,

        Si necesitaramos un pedido en concreto, ya lo gestionaríamos con eventos
     */
    var pedidoConArticuloUiState : PedidoConArticuloUiState = PedidoConArticuloUiState(

        articulos = pedidoRepository.get(1)!!.articulos!!.toArticulosConPedido(),
        pedidoId = 1,
        total = 0f,
        fecha = pedidoRepository.get(1)!!.fecha

    )

    //
    /*
        en articulodepedido tenemos la id del articulo que necesitaremos para la
            url de la imagen en ArticuloConPedido
     */

    fun ArticuloDePedido.toArticulosConPedido() : ArticuloConPedido
    {
        val urlArticulo = articuloRepository.get(this.articuloId)?.url
        val precioArticulo = articuloRepository.get(this.articuloId)?.precio

        return ArticuloConPedido(
            urlArticulo!!,this.tamaño,precioArticulo!!,this.cantidad
        )
    }

    fun List<ArticuloDePedido>.toArticulosConPedido() : List<ArticuloConPedido>
    {
        return this.map { it.toArticulosConPedido() }
    }

    fun Pedido.toPedidoConArticuloUiState() : PedidoConArticuloUiState
    {
        return PedidoConArticuloUiState(
            this.articulos.toArticulosConPedido(),
            this.pedidoId,
            this.total,
            this.fecha
        )
    }


}