package ui.features

import data.UsuarioRepository
import data.models.Usuario
import views.main

class UsuarioViewModel {

    val usuarioRepository : UsuarioRepository = UsuarioRepository()
    var usuarioUiState : UsuarioUiState? = null

    fun onUsuarioEvent(usuarioEvent : UsuarioEvent)
    {
        when(usuarioEvent)
        {
            is UsuarioEvent.AñadeUsuario ->
                usuarioRepository.insert(Usuario(usuarioEvent.login,usuarioEvent.password))
            is UsuarioEvent.EntraSistema ->{
                if (usuarioRepository.get().contains(Usuario(usuarioEvent.login,usuarioEvent.password)))
                {
                    usuarioUiState = UsuarioUiState(usuarioEvent.login,usuarioEvent.password,estaLogueado = true)
                }
            }

            is UsuarioEvent.SaleSistema -> {
                if(usuarioUiState?.estaLogueado == true){usuarioUiState?.estaLogueado = false}
                else{
                    println("Debes de estar logueado para salir")
                }
            }
            is UsuarioEvent.RecetasMenu ->{
                if (!usuarioUiState!!.estaLogueado){
                    print("Debes entrar en el sistema")
                    return
                }


                val recetasViewModel = RecetaViewModel()

                var condicionSalida : Int = 0

                while (condicionSalida != 5)
                {
                    recetaScreen { recetasEvent ->
                        when(recetasEvent)
                        {
                            is RecetasEvent.SeleccionarReceta->
                            {recetasViewModel.onRecetasEvent(recetasEvent)}
                            is RecetasEvent.DeseleccionarReceta->
                            {recetasViewModel.onRecetasEvent(recetasEvent)}
                            is RecetasEvent.CambiarPrioridad->
                            {
                                recetasViewModel.onRecetasEvent(recetasEvent)
                            }
                            is RecetasEvent.MostrarTodas->{
                                recetasViewModel.onRecetasEvent(recetasEvent)
                            }
                            is RecetasEvent.ImprimirSeleccion->
                            {
                                recetasViewModel.onRecetasEvent(recetasEvent)
                            }
                            is RecetasEvent.VolverPantallaAnterior->
                            {
                                condicionSalida = 5
                            }

                        }
                    }
                }

            }

            is UsuarioEvent.ModificaUsuario -> {
                if(usuarioUiState!!.estaLogueado)
                {
                    usuarioUiState?.password = usuarioEvent.password
                }else{
                    println("Debes entrar al sistema primero.")
                }


            }
        }
    }

}