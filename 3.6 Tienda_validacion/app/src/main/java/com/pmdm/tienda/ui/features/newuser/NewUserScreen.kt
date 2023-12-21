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
import com.pmdm.tienda.ui.features.newuser.NewUserUiState
import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesEvent
import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.datospersonales.ValidacionDatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionEvent
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionUiState
import com.pmdm.tienda.ui.features.newuser.direccion.ValidacionDireccionUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordEvent
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.ValidacionNewUserPasswordUiState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewUserScreen(
    newUserUiState: NewUserUiState,
    datosPersonalesEvent: (DatosPersonalesEvent,) -> Unit,
    direccionEvent: (DireccionEvent) -> Unit,
    newUserPasswordEvent: (NewUserPasswordEvent) -> Unit
    /*
    datosPersonalesUiState: DatosPersonalesUiState,
    validadorDatosPersonalesUiState: ValidacionDatosPersonalesUiState,
    direccionUiState: DireccionUiState,
    validadorDireccionUiState: ValidacionDireccionUiState,
    newUserPasswordUiState: NewUserPasswordUiState,
    validadorNewUserPasswordUiState: ValidacionNewUserPasswordUiState,
    datosPersonalesEvent: (DatosPersonalesEvent,) -> Unit,
    direccionEvent: (DireccionEvent) -> Unit,
    newUserPasswordEvent: (NewUserPasswordEvent) -> Unit
*/

) {
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
                        datosPersonalesUIState = newUserUiState.datosPersonalesUiState,
                        validadorDatosPersonalesUIState = newUserUiState.validacionDatosPersonalesUiState,
                        datosPersonalesEvent = datosPersonalesEvent
                    )
                }
                1->{
                    DireccionScreen(
                        direccionUiState = newUserUiState.direccionUiState,
                        validadorDireccionUiState = newUserUiState.validacionDireccionUiState,
                        direccionEvent = direccionEvent
                    )
                }
                2->{
                    NuevoUsuarioPassword(
                        newUserPasswordUiState = newUserUiState.newUserPasswordUiState,
                        validadorNewUserPasswordUiState = newUserUiState.validacionNewUserPasswordUiState,
                        newUserPasswordEvent = newUserPasswordEvent
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