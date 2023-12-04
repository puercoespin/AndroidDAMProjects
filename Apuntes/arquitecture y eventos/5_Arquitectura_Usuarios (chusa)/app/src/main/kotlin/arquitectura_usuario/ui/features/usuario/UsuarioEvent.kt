package arquitectura_usuario.ui.features.usuario


sealed interface UsuarioEvent {
    data class AñadeUsuario(val login: String, val password: String) : UsuarioEvent
    data class ModificaUsuario( val password: String) : UsuarioEvent
    data class EntraSistema(val login: String, val password: String) : UsuarioEvent
    object SaleSistema:UsuarioEvent
    object MuestraUsuarios : UsuarioEvent
}