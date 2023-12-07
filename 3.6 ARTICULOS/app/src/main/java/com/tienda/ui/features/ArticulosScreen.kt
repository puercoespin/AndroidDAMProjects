package com.tienda.ui.features


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pmdm.lista_articulos.ui.features.pedidos.PedidoConArticuloUiState
import com.tienda.ui.composables.CardPedido


@Composable
fun ArticulosScreen(
    modifier: Modifier = Modifier,
    pedidoConArticuloUiState: PedidoConArticuloUiState
) {
    Box(modifier = modifier.then(Modifier.fillMaxSize())) {

        LazyColumn(contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp))
        {
            items(pedidoConArticuloUiState.articulos)
            {
                articulo->
                    CardPedido(
                        precio = articulo.precio,
                        cantidad = articulo.cantidad,
                        imagen = articulo.url
                    )
            }
        }

        /*
        LazyColumn(
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        )
        {
            items(
                pedidoConArticuloUiState
            )
            { articulo ->
                CardPedido(precio = pedidoConArticuloUiState.articulos, cantidad = )

            }

        }
         */


    }
}