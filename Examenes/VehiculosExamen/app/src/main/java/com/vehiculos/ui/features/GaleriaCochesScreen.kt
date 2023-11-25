package com.vehiculos.ui.features

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vehiculos.ui.composables.CardCoche
import com.vehiculos.ui.composables.ReservaDialogue
import com.vehiculos.ui.features.cochesFicha.CochesEvent
import com.vehiculos.ui.features.cochesFicha.FichaCocheUiState
import com.vehiculos.ui.features.reserva.ReservaUiState
import com.vehiculos.ui.theme.ProyectoBaseTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CocheScreen(
    cocheUiState: SnapshotStateList<FichaCocheUiState>,
    reservaUiState: ReservaUiState,
    onCochesEvent: (CochesEvent) -> Unit,
    coches:MutableList<FichaCocheUiState>
) {

    ProyectoBaseTheme {

        Box(modifier = Modifier.fillMaxHeight())
        {
            var pageState = rememberPagerState(pageCount = { coches.size })
            HorizontalPager(
                state = pageState,
                modifier = Modifier
            ) {
                page->CardCoche(coche = cocheUiState[page], onCochesEvent = onCochesEvent)
            }

            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.Center
            )
            {
                repeat(coches.size) { iteration ->
                    val color =
                        if (pageState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(20.dp)
                    )
                }
            }

/*
            if()
            {
                ReservaDialogue(reservaUiState = reservaUiState)
            }
*/

        }

    }
}