package ui.features

fun recetaScreen(recetaEvent: (RecetasEvent) -> Unit) {
    println("Menú de recetas")
    println(
        "1. Seleccionar/Deseleccionar recetas\n" +
                "2. Imprimir seleccionadas\n" +
                "3. Mostrar todas\n" +
                "4. Cambiar prioridad\n" +
                "5. Volver"
    )
    var respuesta: String = readln()

    when (respuesta) {
        "1" -> {
            println("1.Seleccionar\n2.Deseleccionar")
            val opcion: String = readln()

            when (opcion) {
                "1" -> {
                    println("Introduce el id de la receta")
                    val id = readln().toInt()
                    recetaEvent(RecetasEvent.SeleccionarReceta(id))
                }

                "2" -> {
                    println("Introduce el id de la receta")
                    val id = readln().toInt()
                    recetaEvent(RecetasEvent.DeseleccionarReceta(id))
                }
            }
        }
        "2" -> {
            recetaEvent(RecetasEvent.ImprimirSeleccion)
        }
        "3"->{
            recetaEvent(RecetasEvent.MostrarTodas)
        }
        "4"->{
            recetaEvent(RecetasEvent.CambiarPrioridad)
        }
        "5"->{recetaEvent(RecetasEvent.VolverPantallaAnterior)}
    }
}