package views

import data.models.Usuario
import ui.features.UsuarioEvent
import ui.features.UsuarioViewModel
import ui.features.usuarioScreen

fun main() {

    val usuarioViewModel = UsuarioViewModel()

    while (true) {
        usuarioScreen { usuarioEvent ->

            when (usuarioEvent) {
                is UsuarioEvent.AñadeUsuario -> {
                    usuarioViewModel.onUsuarioEvent(usuarioEvent)
                }

                is UsuarioEvent.EntraSistema -> {
                    usuarioViewModel.onUsuarioEvent(usuarioEvent)
                }

                is UsuarioEvent.SaleSistema -> {
                    usuarioViewModel.onUsuarioEvent(usuarioEvent)
                }

                is UsuarioEvent.RecetasMenu -> {
                    usuarioViewModel.onUsuarioEvent(usuarioEvent)
                }

                is UsuarioEvent.ModificaUsuario -> {
                    usuarioViewModel.onUsuarioEvent(usuarioEvent)
                }
            }
        }
    }
}