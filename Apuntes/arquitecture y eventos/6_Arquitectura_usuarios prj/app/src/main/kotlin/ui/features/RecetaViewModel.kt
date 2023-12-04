package ui.features

import data.RecetaRepository
import data.mock.RecetaDaoMock
import data.models.Receta
import data.toRecetaMock

class RecetaViewModel {
    val recetaRepository: RecetaRepository = RecetaRepository()
    var recetaUiState: RecetaUiState? = null
    private val recetaSeleccion = mutableListOf<RecetaUiState>()

    fun onRecetasEvent(recetasEvent: RecetasEvent) {

        when (recetasEvent) {
            is RecetasEvent.SeleccionarReceta -> {
                var receta : Receta? = recetaRepository.get(recetasEvent.id)
                var recetaState = RecetaUiState(receta!!.id, recetaSeleccion.size,receta!!.cookingTime,
                    receta!!.recipeName,receta!!.recipePicture,receta!!.chefName,receta!!.chefMail,
                    receta!!.chefPicture)

                recetaSeleccion.add(recetaState)
            }

            is RecetasEvent.DeseleccionarReceta->{
                recetaSeleccion.removeIf{it.id == recetasEvent.id}
            }

            is RecetasEvent.CambiarPrioridad -> {
                val nuevoOrden = mutableListOf<RecetaUiState>()
                println("Recetas seleccionadas: ")
                recetaSeleccion.sortedBy { it.prioridad }.forEach{a -> println(a) }

                println("Introduce el orden de las recetas")
                for (i in 0..recetaSeleccion.size-1)
                {
                    val recetaIndex = readln().toInt()
                    recetaSeleccion[i].prioridad = recetaIndex
                }
            }
            is RecetasEvent.ImprimirSeleccion -> {
                recetaSeleccion.sortedBy { it.prioridad }.forEach{a -> println(a) }
            }
            is RecetasEvent.MostrarTodas -> {
                recetaRepository.get().forEach{a->println(a)}
            }
            is RecetasEvent.VolverPantallaAnterior->
            {
                println("Saliendo...")
            }
        }

    }
}