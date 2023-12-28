package com.pmdm.tienda.models

/*
    ArticuloDePedido es una clase que hace referencia a un articulo, tiene una id que lo enlaza
    de esta manera podemos poner una variable cantidad, que hace referencia al numero de articulos del mismo tipo
 */

data class ArticuloDePedido(
    val articuloId: Int,
    val tamaño: Short,
    val cantidad: Int
)

data class Pedido(
    val pedidoId: Long,
    val dniCliente: String,
    val total: Float,
    val fecha: Long,
    val articulos: MutableList<ArticuloDePedido>
)
