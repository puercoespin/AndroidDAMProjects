import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.foundation.pager.HorizontalPager

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.pmdm.tienda.ui.features.DatosPersonales
import com.pmdm.tienda.ui.features.DireccionScreen
import com.pmdm.tienda.ui.features.NuevoUsuarioPassword
import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.datospersonales.ValidacionDatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionUiState
import com.pmdm.tienda.ui.features.newuser.direccion.ValidacionDireccionUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.ValidacionNewUserPasswordUiState


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun NewUserScreen() {
    //Variables de prueba
    var datosPersonalesUiState = DatosPersonalesUiState()
    var validadorDatosPersonalesUiState = ValidacionDatosPersonalesUiState()
    var direccionUiState = DireccionUiState()
    var validadorDUiState = ValidacionDireccionUiState()
    var newUserPasswordUiState = NewUserPasswordUiState()
    var validadornu = ValidacionNewUserPasswordUiState()

    // Los puntos no salen abajo por el tamaño de los formularios
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    Column {
        HorizontalPager(
            state = pagerState,
        ) { page ->
            // Our page content
            when(page)
            {
                0->{
                    DatosPersonales(
                        datosPersonalesUIState = datosPersonalesUiState,
                        validadorDatosPersonalesUIState = validadorDatosPersonalesUiState,
                        datosPersonalesEvent = {}
                    )
                }
                1->{
                    DireccionScreen(
                        direccionUiState = direccionUiState,
                        validadorDireccionUiState = validadorDUiState,
                        direccionEvent = {}
                    )
                }
                2->{
                    NuevoUsuarioPassword(
                        newUserPasswordUiState = newUserPasswordUiState,
                        validadorNewUserPasswordUiState = validadornu,
                        newUserPasswordEvent = {}
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}