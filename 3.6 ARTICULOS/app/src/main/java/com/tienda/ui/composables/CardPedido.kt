package com.tienda.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.articulos.R
import com.pmdm.lista_articulos.ui.features.pedidos.PedidoConArticuloUiState
import com.tienda.ui.features.ArticulosViewModel
import com.tienda.ui.theme.ProyectoBaseTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun CardPedido(
    precio : Float,
    cantidad : Int,
    imagen : String
)
{
    val contexto = LocalContext.current
    val imageResource = contexto.resources.getIdentifier(imagen,null,contexto.packageName)

    ProyectoBaseTheme {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(7.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(color = Color(0xFF6dc0a4))
                    .fillMaxWidth()

            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp, 80.dp)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                )


                {
                    Image(
                        // falta poner su imagen, como es url no sé cómo se le dice un path
                        painter = painterResource(
                            id = imageResource
                        ),
                        contentDescription = "$imagen",
                        modifier = Modifier
                            .aspectRatio(ratio = 1f)
                            .background(MaterialTheme.colorScheme.surface),
                        contentScale = ContentScale.Crop
                    )
                }

                Column {
                    Text( //Talla
                        modifier = Modifier
                            .padding(8.dp),
                        text = "Talla",
                        color = Color.Black)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text( //precio
                            modifier = Modifier
                                .padding(8.dp),
                            text = "Precio ${precio}",
                            color = Color.Black)

                        Text( //cantidad
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            text = "Cantidad $cantidad",
                            color = Color.Black,
                            textAlign = TextAlign.End
                        )
                    }
                }

            }
        }
    }
}

@Preview(
    name = "PORTRAIT",
    device = "spec:width=360dp,height=800dp,dpi=480",
    showBackground = true
)
@Composable
fun CardPreview()
{
    CardPedido(precio = 10f, cantidad = 10, imagen = "drawable/imagen1")
}