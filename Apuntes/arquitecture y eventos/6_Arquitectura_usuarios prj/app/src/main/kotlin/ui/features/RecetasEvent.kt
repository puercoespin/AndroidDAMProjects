package ui.features

sealed interface RecetasEvent {
    data class SeleccionarReceta(
        val id: Int
    ) : RecetasEvent

    data class DeseleccionarReceta(
        val id: Int
    ) : RecetasEvent

    object ImprimirSeleccion:RecetasEvent
    object MostrarTodas:RecetasEvent

    object CambiarPrioridad:RecetasEvent // cambiara el orden de las recetas en la lista

    object VolverPantallaAnterior:RecetasEvent
}