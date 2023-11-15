package ui.features

import data.UsuarioRepository
import data.models.Usuario

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
                if(usuarioUiState?.estaLogueado == false){usuarioUiState?.estaLogueado = true}
                else{
                    println("Debes de estar logueado para salir")
                }
            }
            is UsuarioEvent.MuestraUsuarios ->{
                if (usuarioRepository.get().size==0){
                    print("No existen usuarios que mostrar")
                }
                usuarioRepository.get().forEach{a-> println(a) }
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