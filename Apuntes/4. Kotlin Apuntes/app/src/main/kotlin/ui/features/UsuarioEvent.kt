package ui.features

sealed interface UsuarioEvent{
    data class AñadeUsuario(val login : String,val password : String ) : UsuarioEvent
    data class EntraSistema(val login : String,val password : String ) : UsuarioEvent
    object SaleSistema : UsuarioEvent
    object MuestraUsuarios : UsuarioEvent
    data class ModificaUsuario(val password : String) : UsuarioEvent

}

