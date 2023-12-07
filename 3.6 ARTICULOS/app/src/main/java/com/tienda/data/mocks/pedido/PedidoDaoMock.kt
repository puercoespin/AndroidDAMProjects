package com.pmdm.tienda.data.mocks.pedido

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.O)
class PedidoDaoMock @Inject constructor() {
    private var pedidos = mutableListOf<PedidoMock>()
    private var pedidoConArticulos = mutableListOf<ArticuloConPedidoMock>()

    fun insert(pedido: PedidoMock, articulos: List<ArticuloConPedidoMock>) {
        pedidos.add(pedido)
        articulos.forEach { a ->
            pedidoConArticulos.add(
                ArticuloConPedidoMock(
                    a.articuloId,
                    pedido.pedidoId,
                    a.tamaño,
                    a.cantidad
                )
            )
        }
    }

    fun delete(pedido: PedidoMock) {
        val p = pedidos.find { pedido.pedidoId == it.pedidoId }
        if (p != null) pedidos.remove(p)
    }

    fun update(pedido: PedidoMock) {
        val p = pedidos.find { pedido.pedidoId == it.pedidoId }
        if (p != null) {
            val i = pedidos.lastIndexOf(p)
            if (i != -1) pedidos.removeAt(i)
        }
    }

    fun getPedidos(): List<PedidoMock> = pedidos
    fun getPedido(pedidoId: Long): PedidoMock? {
        return pedidos.find { pedidoId == it.pedidoId }
    }

    fun getPedidos(dniCliente: String): List<PedidoMock> =
        pedidos.filter { p -> p.dniCliente == dniCliente }

    fun getArticulosPedido(pedidoId: Long): List<ArticuloConPedidoMock> {
        return pedidoConArticulos.filter { pedidoId == it.pedidoId }
    }

    fun guardarArticuloPedido(pedido: ArticuloConPedidoMock) {
        pedidoConArticulos.add(pedido)
    }

    fun getCantidadArticulosEnPedido(pedidoId: Long): Int {
        return pedidoConArticulos.filter { pedidoId == it.pedidoId }.count()
    }
    /*
        Tenemos 3 pedidos: id 1, 2, 3

            Tenemos una lista de pedidosConArticulo que "enlaza" un articulo con un pedido
                el articulo con id 4 se enlaza al pedido con id 1
                el articulo con id 6 se enlaza al pedido con id 1 etc



     */
    init {
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 4, pedidoId = 1, tamaño = 1,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 6, pedidoId = 1, tamaño = 1,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 8, pedidoId = 1, tamaño = 1,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 13, pedidoId = 1, tamaño = 2,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 14, pedidoId = 1, tamaño = 1,
                cantidad = 2
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 6, pedidoId = 1, tamaño = 3,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 11, pedidoId = 1, tamaño = 1,
                cantidad = 3
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 16, pedidoId = 1, tamaño = 2,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 10, pedidoId = 1, tamaño = 2,
                cantidad = 2
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 14, pedidoId = 2, tamaño = 2,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 8, pedidoId = 2, tamaño = 2,
                cantidad = 1
            )
        )
        pedidoConArticulos.add(
            ArticuloConPedidoMock(
                articuloId = 6, pedidoId = 3, tamaño = 3,
                cantidad = 2
            )
        )
        pedidos.add(
            PedidoMock(
                pedidoId = 1, dniCliente = "22222222L",
                total = 800f, fecha = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()
            )
        )
        pedidos.add(
            PedidoMock(
                pedidoId = 2, dniCliente = "22222222L",
                total = 300f, fecha = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()
            )
        )
        pedidos.add(
            PedidoMock(
                pedidoId = 3, dniCliente = "22222222L",
                total = 150f, fecha = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()
            )
        )

    }

}
